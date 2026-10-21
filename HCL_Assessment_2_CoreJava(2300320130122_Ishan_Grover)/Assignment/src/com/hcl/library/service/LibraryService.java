
package com.hcl.library.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.hcl.library.exception.ItemNotFoundException;
import com.hcl.library.exception.ItemNotAvailableException;
import com.hcl.library.exception.LibraryException;
import com.hcl.library.model.Book;
import com.hcl.library.model.LibraryItem;
import com.hcl.library.model.Member;
import com.hcl.library.repository.InMemoryRepository;
import com.hcl.library.repository.Repository;
import com.hcl.library.util.CollectionUtils;
import com.hcl.library.util.SearchCache;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LibraryService {

    private static final int PAGE_SIZE = 5;

    private final Repository<LibraryItem, Integer> itemRepository;
    private final Repository<Member, Integer> memberRepository;

    private final Map<Integer, Queue<Member>> waitlists =
            new HashMap<>();

    private final SearchCache searchCache = new SearchCache();

    public LibraryService() {
        itemRepository = new InMemoryRepository<>(LibraryItem::getId);
        memberRepository = new InMemoryRepository<>(Member::getMemberId);
    }

    public void addItem(LibraryItem item) {
        if (item instanceof Book) {
            checkDuplicateIsbn((Book) item);
        }

        itemRepository.save(item);
    }

    private void checkDuplicateIsbn(Book newBook) {
        for (LibraryItem item : itemRepository.findAll()) {
            if (item instanceof Book) {
                Book book = (Book) item;

                if (book.getIsbn().equalsIgnoreCase(newBook.getIsbn())) {
                    throw new LibraryException(
                            "A book with this ISBN already exists.");
                }
            }
        }
    }

    public Member registerMember(String name, String email) {
        Member member = new Member(name, email);
        memberRepository.save(member);
        return member;
    }

    public LibraryItem findItem(int itemId) {
        LibraryItem item = itemRepository.findById(itemId);

        if (item == null) {
            throw new ItemNotFoundException(
                    "Item with ID " + itemId + " was not found.");
        }

        return item;
    }

    public Member findMember(int memberId) {
        Member member = memberRepository.findById(memberId);

        if (member == null) {
            throw new LibraryException(
                    "Member with ID " + memberId + " was not found.");
        }

        return member;
    }

    public void borrowItem(int itemId, int memberId) {
        LibraryItem item = findItem(itemId);
        Member member = findMember(memberId);

        if (!item.isAvailable()) {
            throw new ItemNotAvailableException(
                    "Item is already issued.");
        }

        member.borrowItem(item);
        item.borrow();
    }

    public void returnItem(int itemId, int memberId) {
        LibraryItem item = findItem(itemId);
        Member member = findMember(memberId);

        if (!member.getBorrowedItems().contains(item)) {
            throw new LibraryException(
                    "This member has not borrowed this item.");
        }

        item.giveback();
        member.returnItem(item);

        notifyNextMember(itemId);
    }

    public void joinWaitlist(int itemId, int memberId) {
        LibraryItem item = findItem(itemId);
        Member member = findMember(memberId);

        if (item.isAvailable()) {
            throw new LibraryException(
                    "The item is available. No waitlist is needed.");
        }

        Queue<Member> queue = waitlists.get(itemId);

        if (queue == null) {
            queue = new ArrayDeque<>();
            waitlists.put(itemId, queue);
        }

        if (!queue.contains(member)) {
            queue.offer(member);
        }
    }

    private void notifyNextMember(int itemId) {
        Queue<Member> queue = waitlists.get(itemId);

        if (queue != null && !queue.isEmpty()) {
            Member nextMember = queue.poll();

            System.out.println(
                    "Waitlist notification: "
                            + nextMember.getName()
                            + ", item ID " + itemId
                            + " is now available.");
        }
    }

    public List<LibraryItem> listItems() {
        return itemRepository.findAll();
    }

    public List<LibraryItem> sortItemsByYear() {
        List<LibraryItem> items = listItems();
        Comparator<LibraryItem> comparator =
                CollectionUtils.byYearDescending();

        items.sort(comparator);
        return items;
    }

    public List<LibraryItem> searchItems(String keyword) {
        List<LibraryItem> results = new ArrayList<>();

        if (keyword == null) {
            return results;
        }

        for (LibraryItem item : listItems()) {
            if (item.getTitle().toLowerCase()
                    .contains(keyword.toLowerCase())) {
                results.add(item);
                searchCache.add(item);
            }
        }

        return results;
    }

    public List<LibraryItem> getSearchPage(
            List<LibraryItem> results, int pageNumber) {

        List<LibraryItem> page = new ArrayList<>();

        if (pageNumber < 1) {
            return page;
        }

        int start = (pageNumber - 1) * PAGE_SIZE;
        int end = Math.min(start + PAGE_SIZE, results.size());

        for (int i = start; i < end; i++) {
            page.add(results.get(i));
        }

        return page;
    }

    public List<LibraryItem> getRecentSearchItems() {
        return searchCache.getRecentItems();
    }

    public double calculateLateFee(int itemId, int daysLate) {
        LibraryItem item = findItem(itemId);
        return item.lateFee(daysLate);
    }

    public void removeOldItems(int beforeYear) {
        List<LibraryItem> items = itemRepository.findAll();
        Iterator<LibraryItem> iterator = items.iterator();

        while (iterator.hasNext()) {
            LibraryItem item = iterator.next();

            if (item.getYear() < beforeYear) {
                iterator.remove();
                itemRepository.deleteById(item.getId());
            }
        }
    }

    public LibraryItem findMaximumItem() {
        return CollectionUtils.max(listItems());
    }

    public void exportReport(String fileName) {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileName))) {

            writer.write("Library Report");
            writer.newLine();
            writer.write("====================");
            writer.newLine();

            writer.write(buildReport());

        } catch (IOException e) {
            throw new LibraryException(
                    "Could not export the library report.", e);
        }
    }

    public String buildReport() {
        StringBuilder report = new StringBuilder();

        for (LibraryItem item : listItems()) {
            report.append(item).append(System.lineSeparator());
        }

        return report.toString();
    }
}

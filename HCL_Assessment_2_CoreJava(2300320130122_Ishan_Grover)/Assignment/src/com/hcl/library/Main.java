
package com.hcl.library.exception;

import com.hcl.library.exception.BorrowLimitExceededException;
import com.hcl.library.exception.ItemNotAvailableException;
import com.hcl.library.exception.ItemNotFoundException;
import com.hcl.library.exception.LibraryException;
import com.hcl.library.model.Book;
import com.hcl.library.model.DVD;
import com.hcl.library.model.LibraryItem;
import com.hcl.library.model.Magazine;
import com.hcl.library.model.Member;
import com.hcl.library.service.LibraryService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final LibraryService library = new LibraryService();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();

            try {
                int choice = readInt("Enter your choice: ");

                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        registerMember();
                        break;
                    case 3:
                        borrowItem();
                        break;
                    case 4:
                        returnItem();
                        break;
                    case 5:
                        joinWaitlist();
                        break;
                    case 6:
                        listItems();
                        break;
                    case 7:
                        searchItems();
                        break;
                    case 8:
                        exportReport();
                        break;
                    case 9:
                        running = false;
                        System.out.println("Exiting Library System.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (ItemNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (ItemNotAvailableException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (BorrowLimitExceededException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (LibraryException e) {
                System.out.println("Library error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            } finally {
                if (running) {
                    System.out.println("\nReturning to the main menu.\n");
                }
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Item");
        System.out.println("2. Register Member");
        System.out.println("3. Borrow Item");
        System.out.println("4. Return Item");
        System.out.println("5. Join Waitlist");
        System.out.println("6. List Items");
        System.out.println("7. Search Items");
        System.out.println("8. Export Report");
        System.out.println("9. Exit");
    }

    private static int readInt(String message) {
        System.out.print(message);
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private static String readText(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static void addItem() {
        System.out.println("1. Book");
        System.out.println("2. Magazine");
        System.out.println("3. DVD");

        int type = readInt("Select item type: ");
        String title = readText("Enter title: ");
        int year = readInt("Enter publication year: ");

        LibraryItem item;

        switch (type) {
            case 1:
                String author = readText("Enter author: ");
                String isbn = readText("Enter ISBN: ");
                item = new Book(title, year, author, isbn);
                break;
            case 2:
                int issueNumber = readInt("Enter issue number: ");
                item = new Magazine(title, year, issueNumber);
                break;
            case 3:
                int duration = readInt("Enter duration in minutes: ");
                item = new DVD(title, year, duration);
                break;
            default:
                System.out.println("Invalid item type.");
                return;
        }

        library.addItem(item);
        System.out.println("Item added successfully. ID: " + item.getId());
    }

    private static void registerMember() {
        String name = readText("Enter member name: ");
        String email = readText("Enter member email: ");

        Member member = library.registerMember(name, email);

        System.out.println("Member registered successfully.");
        System.out.println("Member ID: " + member.getMemberId());
    }

    private static void borrowItem() {
        int itemId = readInt("Enter item ID: ");
        int memberId = readInt("Enter member ID: ");

        library.borrowItem(itemId, memberId);
        System.out.println("Item borrowed successfully.");
    }

    private static void returnItem() {
        int itemId = readInt("Enter item ID: ");
        int memberId = readInt("Enter member ID: ");
        int daysLate = readInt("Enter days late (0 if not overdue): ");

        double fee = library.calculateLateFee(itemId, daysLate);
        library.returnItem(itemId, memberId);

        System.out.println("Item returned successfully.");
        System.out.println("Late fee: " + fee);
    }

    private static void joinWaitlist() {
        int itemId = readInt("Enter item ID: ");
        int memberId = readInt("Enter member ID: ");

        library.joinWaitlist(itemId, memberId);
        System.out.println("Added to the waitlist.");
    }

    private static void listItems() {
        List<LibraryItem> items = library.sortItemsByYear();

        if (items.isEmpty()) {
            System.out.println("No items in the library.");
            return;
        }

        StringBuilder report = new StringBuilder();

        for (LibraryItem item : items) {
            report.append(item).append(System.lineSeparator());
        }

        System.out.print(report);
    }

    private static void searchItems() {
        String keyword = readText("Enter title keyword: ");
        List<LibraryItem> results = library.searchItems(keyword);

        if (results.isEmpty()) {
            System.out.println("No matching items found.");
            return;
        }

        System.out.println("Found " + results.size() + " item(s).");
        int page = readInt("Enter page number (5 items per page): ");

        List<LibraryItem> pageItems = library.getSearchPage(results, page);

        if (pageItems.isEmpty()) {
            System.out.println("Invalid or empty page.");
            return;
        }

        for (LibraryItem item : pageItems) {
            System.out.println(item);
        }
    }

    private static void exportReport() {
        String fileName = readText(
                "Enter report filename (e.g. library-report.txt): ");

        library.exportReport(fileName);
        System.out.println("Report exported successfully.");
    }
}

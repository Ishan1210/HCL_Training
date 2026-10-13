
package com.hcl.library.model;

import com.hcl.library.exception.BorrowLimitExceededException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {

    private static final int MAX_BORROW_LIMIT = 3;

    private static int nextMemberId = 1;

    private final int memberId;
    private final String name;
    private final String email;
    private final List<LibraryItem> borrowedItems;

    public Member(String name, String email) {
        this(nextMemberId++, name, email);
    }

    public Member(int memberId, String name, String email) {
        if (memberId <= 0) {
            throw new IllegalArgumentException(
                    "Member ID must be positive.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Name cannot be empty.");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException(
                    "Email must contain @.");
        }

        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.borrowedItems = new ArrayList<>();

        if (memberId >= nextMemberId) {
            nextMemberId = memberId + 1;
        }
    }

    public void borrowItem(LibraryItem item) {
        if (borrowedItems.size() >= MAX_BORROW_LIMIT) {
            throw new BorrowLimitExceededException(
                    "A member cannot borrow more than three items.");
        }

        borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<LibraryItem> getBorrowedItems() {
        return Collections.unmodifiableList(borrowedItems);
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId
                + ", Name: " + name
                + ", Email: " + email
                + ", Borrowed Items: " + borrowedItems.size();
    }
}

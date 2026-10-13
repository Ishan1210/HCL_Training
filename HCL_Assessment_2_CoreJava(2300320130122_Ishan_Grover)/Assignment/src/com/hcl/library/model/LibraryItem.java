package com.hcl.library.model;
import com.hcl.library.exception.ItemNotAvailableException;

public abstract class LibraryItem
        implements Borrowable, Comparable<LibraryItem> {

    private static final int STARTING_ID = 1001;
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2026;

    private static int counter = STARTING_ID;

    private final int id;
    private final String title;
    private final int year;
    private boolean available;

    public LibraryItem(String title, int year) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Title cannot be empty.");
        }

        if (year < MIN_YEAR || year > MAX_YEAR) {
            throw new IllegalArgumentException(
                    "Year must be between 1900 and 2026.");
        }

        this.id = counter++;
        this.title = title;
        this.year = year;
        this.available = true;
    }

    public abstract double lateFee(int daysLate);

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void borrow() {
        if (!available) {
            throw new ItemNotAvailableException(
                    "Item is already issued.");
        }

        available = false;
    }

    @Override
    public void giveback() {
        available = true;
    }

    @Override
    public int compareTo(LibraryItem other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LibraryItem)) {
            return false;
        }

        LibraryItem other = (LibraryItem) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", Title: " + title
                + ", Year: " + year
                + ", Available: " + available;
    }
}

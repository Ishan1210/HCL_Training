
package com.hcl.library.model;

public class Book extends LibraryItem {

    private static final double DAILY_LATE_FEE = 2.0;

    private String author;
    private String isbn;

    public Book(String title, int year, String author, String isbn) {
        super(title, year);

        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Author cannot be empty.");
        }

        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "ISBN cannot be empty.");
        }

        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public double lateFee(int daysLate) {
        if (daysLate <= 0) {
            return 0.0;
        }

        return daysLate * DAILY_LATE_FEE;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Author: " + author
                + ", ISBN: " + isbn;
    }
}

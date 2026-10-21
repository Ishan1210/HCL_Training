
package com.hcl.library.model;

public class Magazine extends LibraryItem {

    private static final double DAILY_LATE_FEE = 1.0;

    private int issueNumber;

    public Magazine(String title, int year, int issueNumber) {
        super(title, year);

        if (issueNumber <= 0) {
            throw new IllegalArgumentException(
                    "Issue number must be positive.");
        }

        this.issueNumber = issueNumber;
    }

    @Override
    public double lateFee(int daysLate) {
        if (daysLate <= 0) {
            return 0.0;
        }

        return daysLate * DAILY_LATE_FEE;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Issue Number: " + issueNumber;
    }
}

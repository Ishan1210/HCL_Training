
package com.hcl.library.model;

public class DVD extends LibraryItem {

    private static final double DAILY_LATE_FEE = 5.0;

    private int durationMinutes;

    public DVD(String title, int year, int durationMinutes) {
        super(title, year);

        if (durationMinutes <= 0) {
            throw new IllegalArgumentException(
                    "Duration must be positive.");
        }

        this.durationMinutes = durationMinutes;
    }

    @Override
    public double lateFee(int daysLate) {
        if (daysLate <= 0) {
            return 0.0;
        }

        return daysLate * DAILY_LATE_FEE;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Duration: " + durationMinutes + " minutes";
    }
}

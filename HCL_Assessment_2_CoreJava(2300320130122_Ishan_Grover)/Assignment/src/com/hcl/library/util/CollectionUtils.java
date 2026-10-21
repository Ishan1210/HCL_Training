
package com.hcl.library.util;

import java.util.List;
import com.hcl.library.model.LibraryItem;
import java.util.Comparator;



public class CollectionUtils {

    public static <T extends Comparable<T>> T max(List<T> items) {
        if (items == null || items.isEmpty()) {
            return null;
        }

        T maximum = items.get(0);

        for (T item : items) {
            if (item.compareTo(maximum) > 0) {
                maximum = item;
            }
        }

        return maximum;
    }

    public static double totalFees(List<? extends Number> fees) {
        double total = 0.0;

        for (Number fee : fees) {
            total += fee.doubleValue();
        }

        return total;
    }
    public static Comparator<LibraryItem> byYearDescending() {
        return Comparator.comparingInt(LibraryItem::getYear)
                .reversed()
                .thenComparing(LibraryItem::getTitle);
    }
}

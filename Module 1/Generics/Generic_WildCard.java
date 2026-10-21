package Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generic_WildCard {
    public static void printItems(List<?> items) {
        for (Object item : items) {
            System.out.println(item);
        }
    }

    public static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static void addIntegers(List<? super Integer> numbers) {
        numbers.add(10);
        numbers.add(20);
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amit", "Neha", "Riya");
        System.out.println("Unbounded wildcard (?); accepts a list of any type:");
        printItems(names);

        List<Integer> integers = Arrays.asList(10, 20, 30);
        List<Double> decimals = Arrays.asList(1.5, 2.5);
        System.out.println("\nUpper-bounded wildcard (? extends Number):");
        System.out.println("Integer sum: " + sumNumbers(integers));
        System.out.println("Decimal sum: " + sumNumbers(decimals));

        List<Number> values = new ArrayList<>();
        addIntegers(values);
        System.out.println("\nLower-bounded wildcard (? super Integer):");
        printItems(values);
    }
}

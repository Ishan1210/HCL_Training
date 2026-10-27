package Steams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Stream1 {
    public static void main(String[] args) {
        int[] l1 = {1, 2, 3, 4, 5, 6};
        int[] l2 = {10, 20, 30, 40};
        String message = "Stream examples";

        IntStream stream1 = Arrays.stream(l1);
        IntStream stream2 = Arrays.stream(l2);

        System.out.println(message);
        System.out.println("Even numbers in l1:");
        stream1.filter(number -> number % 2 == 0)
                .forEach(System.out::println);

        System.out.println("Values in l2:");
        stream2.forEach(System.out::println);
    }
}

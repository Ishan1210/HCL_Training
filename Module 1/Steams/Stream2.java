package Steams;

import java.util.Arrays;

public class Stream2 {
    public static void main(String[] args) {
        String[] names = {"Amit", "Neha", "Priyanka", "Rahul", "Samantha"};

        Arrays.stream(names)
                .filter(name -> name.length() > 4)
                .forEach(System.out::println);
    }
}

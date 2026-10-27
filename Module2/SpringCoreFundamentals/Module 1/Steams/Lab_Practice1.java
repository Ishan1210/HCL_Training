package Steams;

import java.util.Arrays;

public class Lab_Practice1 {
    public static void main(String[] args) {
        String[] names = {"Ravi", "Amit", "Ananya", "Rahul", "Aarav", "Neha"};

        Arrays.stream(names)
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}

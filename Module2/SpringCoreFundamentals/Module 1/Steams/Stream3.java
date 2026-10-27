package Steams;

import java.util.Arrays;

public class Stream3 {
    public static void main(String[] args) {
        String[] names = {"Ravi", "Neha", "Riya", "Amit", "Rahul"};

        Arrays.stream(names)
                .filter(name -> name.startsWith("R"))
                .forEach(System.out::println);
    }
}

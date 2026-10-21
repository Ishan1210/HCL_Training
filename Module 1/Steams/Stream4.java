package Steams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream4 {
    public static void main(String[] args) {
        String[] names = {"Amit", "Neha", "Ananya", "Ravi", "Aarav"};

        List<String> namesStartingWithA = Arrays.stream(names)
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        namesStartingWithA.forEach(System.out::println);
    }
}

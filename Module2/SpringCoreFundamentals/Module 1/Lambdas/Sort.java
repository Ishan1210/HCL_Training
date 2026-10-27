package Lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(40, 10, 30, 20, 50));

        numbers.sort((first, second) -> Integer.compare(first, second));

        System.out.println("Sorted numbers: " + numbers);
    }
}

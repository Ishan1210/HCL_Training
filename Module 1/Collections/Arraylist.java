package Collections;

import java.util.*;
import java.util.Iterator;

public class Arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        numbers.add(60);
        numbers.add(70);
        numbers.add(80);
        numbers.add(90);
        numbers.add(100);
        numbers.add(110);
        numbers.add(5, 55);

        System.out.println("After add(): " + numbers);

        System.out.println("Element at index 3: " + numbers.get(3));

        int oldValue = numbers.set(3, 45);
        System.out.println("set() replaced " + oldValue + " with 45: " + numbers);

        int removedByIndex = numbers.remove(0);
        boolean removedByValue = numbers.remove(Integer.valueOf(90));
        System.out.println("remove(0) removed: " + removedByIndex);
        System.out.println("remove(90) succeeded: " + removedByValue);
        System.out.println("After remove(): " + numbers);

        System.out.println("Contains 50: " + numbers.contains(50));
        System.out.println("Index of 100: " + numbers.indexOf(100));
        System.out.println("size(): " + numbers.size());

        ArrayList<Integer> sameNumbers = new ArrayList<>(numbers);
        System.out.println("Equals a copy of the list: " + numbers.equals(sameNumbers));

        System.out.print("Elements using iterator(): ");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        Integer[] numberArray = numbers.toArray(new Integer[0]);
        System.out.println("toArray(): " + java.util.Arrays.toString(numberArray));

        int streamSum = numbers.stream().mapToInt(Integer::intValue).sum();
        int parallelStreamSum = numbers.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum using stream(): " + streamSum);
        System.out.println("Sum using parallelStream(): " + parallelStreamSum);

        System.out.println("isEmpty() before clear(): " + numbers.isEmpty());
        numbers.clear();
        System.out.println("After clear(): " + numbers);
        System.out.println("isEmpty() after clear(): " + numbers.isEmpty());
    }
}

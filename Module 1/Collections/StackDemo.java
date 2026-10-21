package Collections;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();

        numbers.push(10);
        numbers.push(20);
        numbers.push(30);
        System.out.println("Stack: " + numbers);

        System.out.println("Top: " + numbers.peek());
        System.out.println("Position of 20 from top: " + numbers.search(20));
        System.out.println("Contains 10: " + numbers.contains(10));
        System.out.println("Size: " + numbers.size());

        System.out.println("Popped: " + numbers.pop());
        System.out.println("Stack: " + numbers);
        System.out.println("Empty: " + numbers.empty());

        numbers.clear();
        System.out.println("After clear: " + numbers);
        System.out.println("Empty: " + numbers.empty());
    }
}

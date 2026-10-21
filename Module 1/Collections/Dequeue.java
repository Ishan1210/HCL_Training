package Collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dequeue {
    public static void main(String[] args) {
        Deque<Integer> numbers = new ArrayDeque<>();

        numbers.push(10);
        numbers.push(20);
        numbers.push(30);
        System.out.println("Stack: " + numbers);

        System.out.println("Top: " + numbers.peek());
        System.out.println("Size: " + numbers.size());

        System.out.println("Popped: " + numbers.pop());
        System.out.println("Stack after pop: " + numbers);

        numbers.clear();
        System.out.println("Stack after clear: " + numbers);
        System.out.println("Empty: " + numbers.isEmpty());
    }
}

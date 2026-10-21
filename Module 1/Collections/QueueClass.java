package Collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueClass {
    public static void main(String[] args) {
        Queue<Integer> numbers = new ArrayDeque<>();

        numbers.offer(10);
        numbers.offer(20);
        numbers.offer(30);
        System.out.println("Queue: " + numbers);

        System.out.println("Front: " + numbers.peek());
        System.out.println("Contains 20: " + numbers.contains(20));
        System.out.println("Size: " + numbers.size());

        System.out.println("Removed: " + numbers.poll());
        System.out.println("Queue after removal: " + numbers);

        numbers.clear();
        System.out.println("Queue after clear: " + numbers);
        System.out.println("Empty: " + numbers.isEmpty());
    }
}

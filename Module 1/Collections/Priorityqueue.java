package Collections;

import java.util.PriorityQueue;

public class Priorityqueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>();

        numbers.offer(30);
        numbers.offer(10);
        numbers.offer(20);
        System.out.println("Priority queue: " + numbers);

        System.out.println("Next item: " + numbers.peek());
        System.out.println("Size: " + numbers.size());

        System.out.println("Removed by priority: " + numbers.poll());
        System.out.println("Next item: " + numbers.peek());

        while (!numbers.isEmpty()) {
            System.out.println("Removed: " + numbers.poll());
        }

        System.out.println("Empty: " + numbers.isEmpty());
    }
}

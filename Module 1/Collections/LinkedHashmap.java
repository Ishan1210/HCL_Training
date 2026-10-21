package Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashmap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> marks = new LinkedHashMap<>();
        marks.put("Mohit", 90);
        marks.put("Vineet", 85);
        marks.put("Champak", 92);
        marks.put("Ravi", 80);

        System.out.println("Marks (in insertion order): " + marks);
        System.out.println("Ravi's marks: " + marks.get("Ravi"));
        System.out.println("Unknown student's marks: " + marks.getOrDefault("Asha", 0));
        System.out.println("Contains Vineet: " + marks.containsKey("Vineet"));
        System.out.println("Contains marks of 92: " + marks.containsValue(92));

        marks.putIfAbsent("Asha", 88);
        marks.putIfAbsent("Ravi", 100);
        System.out.println("After putIfAbsent(): " + marks);

        marks.replace("Vineet", 87);
        System.out.println("After replacing Vineet's marks: " + marks);

        marks.remove("Champak", 92);
        System.out.println("After conditional removal: " + marks);

        System.out.println("Names: " + marks.keySet());
        System.out.println("Marks values: " + marks.values());
        System.out.println("Entries:");
        marks.forEach((name, score) -> System.out.println(name + ": " + score));

        marks.clear();
        System.out.println("Empty after clear: " + marks.isEmpty());
    }
}

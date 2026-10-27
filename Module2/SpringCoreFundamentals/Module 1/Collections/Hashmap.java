package Collections;

import java.util.HashMap;
import java.util.Map;

public class Hashmap {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        scores.put("Asha", 85);
        scores.put("Ravi", 92);
        scores.put("Maya", 78);
        System.out.println("Scores: " + scores);

        System.out.println("Ravi's score: " + scores.get("Ravi"));
        System.out.println("Contains Asha: " + scores.containsKey("Asha"));

        scores.put("Maya", 82);
        System.out.println("Updated Maya's score: " + scores.get("Maya"));

        scores.remove("Asha");
        System.out.println("After removing Asha: " + scores);

        System.out.println("Entries:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scores.clear();
        System.out.println("Empty after clear: " + scores.isEmpty());
    }
}

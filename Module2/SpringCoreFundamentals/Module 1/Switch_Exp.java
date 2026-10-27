public class Switch_Exp {
    public static void main(String[] args) {
        String day = "Monday";

        String type = switch (day) {
            case "Saturday", "Sunday" -> "Weekend";
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday";
            default -> "Invalid Day";
        };

        System.out.println("Day: " + day);
        System.out.println("Type: " + type);
    }
}
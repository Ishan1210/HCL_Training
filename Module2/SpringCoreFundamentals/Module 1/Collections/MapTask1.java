import java.util.*;
record Student(int roll, String name, int marks) {
    @Override
    public String toString() {
        return "[" + roll + ", " + name + ", " + marks + "]";
    }
}
class RollComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.roll() - s2.roll();
    }
}
class MarksComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s2.marks() - s1.marks();
    }
}
public class MapTask1 {
    public static void main(String[] args) {
        System.out.println();
        List<Student> students = new ArrayList<>();
        students.add(new Student(5, "Ravi", 80));
        students.add(new Student(3, "Aman", 84));
        students.add(new Student(6, "Arun", 75));
        students.add(new Student(1, "Gulab", 82));
        students.add(new Student(4, "Manav", 90));
        students.add(new Student(2, "Praharsh", 82));
        System.out.println("Before Sort");
        System.out.println(students);
        Collections.sort(students, new MarksComparator());
        System.out.println("After Sort");
        System.out.println(students);
        Collections.sort(students, new RollComparator().reversed());
        System.out.println("After Sort");
        System.out.println(students);
        System.out.println();
    }}
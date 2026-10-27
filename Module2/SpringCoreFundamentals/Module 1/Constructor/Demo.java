package Constructor;

public class Demo {
    String name;
    int age;

    Demo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Demo a = new Demo("Ishan", 21);

        System.out.println("Name: " + a.name);
        System.out.println("Age: " + a.age);
    }
}
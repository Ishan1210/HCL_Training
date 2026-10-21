sealed class Animal permits Dog, Cat {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

non-sealed class Dog extends Animal {
    public void bark() {
        System.out.println("Woof");
    }
}

final class Cat extends Animal {
    public void meow() {
        System.out.println("Meow");
    }
}

public class Demo {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
        d.bark();

        Cat c = new Cat();
        c.sound();
        c.meow();
    }
}
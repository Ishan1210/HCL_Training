package Abstraction;

interface Animal {
    void sound();

    static int countAnimals() {
        return 2;
    }
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class Interface {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.sound();
        a2.sound();

        System.out.println("Total animals: " + Animal.countAnimals());
    }
}

package Inheritance;

interface A {
    void methodA();
}

interface B {
    void methodB();
}

class C implements A, B {
    @Override
    public void methodA() {
        System.out.println("Method A from interface A");
    }

    @Override
    public void methodB() {
        System.out.println("Method B from interface B");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        C obj = new C();
        obj.methodA();
        obj.methodB();
    }
}

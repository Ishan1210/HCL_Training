package Inheritance;
class Parent {

    void display() {
        System.out.println("Parent display method");
    }

    void show() {
        System.out.println("Parent show method");
    }
}
public class Demo extends Parent {
    void display() {
        System.out.println("Child display method");
    }

    void showBoth() {
        display();
        super.display();
    }

    public static void main(String[] args) {
        Demo p = new Demo();
        Parent p1= new Parent();
        Parent p2= new Demo();
        p.display();
        p1.display();
        p2.display();

    }
}

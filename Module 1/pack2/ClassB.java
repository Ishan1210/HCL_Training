package pack2;

import pack1.ClassA;

public class ClassB {

    public static void main(String[] args) {

        ClassA obj = new ClassA();

        obj.setAge(5);

        System.out.println("Age: " + obj.getAge());
    }
}
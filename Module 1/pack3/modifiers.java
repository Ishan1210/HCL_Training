package pack3;
class A{
    String name;
    public void m1(){
        System.out.println("I am class A");
    }
}
public class modifiers {
    public static void main(String[] args) {
        A a = new A();
        a.m1();
    }
}


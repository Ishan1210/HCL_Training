package Constructor;

class Parent {
    int num = 10;
}

class Super extends Parent {
    int num = 20;

    void show() {
        System.out.println(num);
        System.out.println(super.num);
    }

    public static void main(String[] args) {
        Super obj = new Super();
        obj.show();
    }
}
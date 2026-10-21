package Lambdas;

public class Lambda {
    @FunctionalInterface
    interface Operation {
        int apply(int first, int second);
    }

    public static void main(String[] args) {
        Operation add = (first, second) -> first + second;
        Operation subtract = (first, second) -> first - second;
        Operation multiply = (first, second) -> first * second;

        int first = 20;
        int second = 5;

        System.out.println("Addition: " + add.apply(first, second));
        System.out.println("Subtraction: " + subtract.apply(first, second));
        System.out.println("Multiplication: " + multiply.apply(first, second));
    }
}

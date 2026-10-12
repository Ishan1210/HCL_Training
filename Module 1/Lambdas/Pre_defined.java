package Lambdas;

import java.util.function.*;
public class Pre_defined {
    public static void main(String[] args) {
        Predicate<Integer> isEven = number -> number % 2 == 0;
        int number = 8;
        System.out.println(number + (isEven.test(number) ? " is even." : " is odd."));

        Function<Integer, Integer> square = value -> value * value;
        System.out.println("Square of 5: " + square.apply(5));

        Supplier<String> messageSupplier = () -> "Hello from Supplier!";
        String message = messageSupplier.get();

        Consumer<String> printer = value -> System.out.println("Consumer: " + value);
        printer.accept(message);
    }
}

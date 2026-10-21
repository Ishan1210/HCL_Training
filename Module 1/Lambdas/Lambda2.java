package Lambdas;

public class Lambda2 {
    @FunctionalInterface
    interface NumberChecker {
        boolean isEven(int number);
    }

    public static void main(String[] args) {
        NumberChecker checker = number -> number % 2 == 0;
        int number = 7;

        if (checker.isEven(number)) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }
}

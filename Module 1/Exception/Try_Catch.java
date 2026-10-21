package Exception;

public class Try_Catch {
    public static void main(String[] args) {
        String numeratorInput = args.length > 0 ? args[0] : "10";
        String denominatorInput = args.length > 1 ? args[1] : "0";

        try {
            int numerator = Integer.parseInt(numeratorInput);
            int denominator = Integer.parseInt(denominatorInput);
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid integer values.");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } finally {
            System.out.println("The try-catch example has finished.");
        }
    }
}

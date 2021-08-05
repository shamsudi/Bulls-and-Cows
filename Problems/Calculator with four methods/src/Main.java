// Don't delete this import statement

import java.util.Scanner;

class SimpleCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long num1 = scanner.nextLong();
        String operator = scanner.next();
        long num2 = scanner.nextLong();
        calculate(num1, num2, operator);
    }

    // Implement your methods here
    private static void calculate(long num1, long num2, String operator) {
        switch (operator) {
            case "+":
                sumTwoNumbers(num1, num2);
                break;
            case "-":
                subtractTwoNumbers(num1, num2);
                break;
            case "*":
                multiplyTwoNumbers(num1, num2);
                break;
            case "/":
                divideTwoNumbers(num1, num2);
                break;
            default:
                System.out.println("Unknown operation");
                break;
        }
    }

    public static void subtractTwoNumbers(long num1, long num2) {
        System.out.println(num1 - num2);
    }


    public static void sumTwoNumbers(long num1, long num2) {
        System.out.println(num1 + num2);
    }


    public static void divideTwoNumbers(long num1, long num2) {
        if (num2 == 0) {
            System.out.println("Division by 0!");
            return;
        }
        System.out.println(num1 / num2);
    }


    public static void multiplyTwoNumbers(long num1, long num2) {
        System.out.println(num1 * num2);
    }
}
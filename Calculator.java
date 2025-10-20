import java.util.Scanner;

/**
 * A simple command-line calculator application in Java.
 */
public class Calculator {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user.
        Scanner inputScanner = new Scanner(System.in);
        char operator;
        double number1, number2, result;
        
        // Loop to allow for continuous calculations.
        while (true) {
            System.out.println("Choose an operator: +, -, *, or /");
            operator = inputScanner.next().charAt(0);

            System.out.println("Enter first number");
            number1 = inputScanner.nextDouble();

            System.out.println("Enter second number");
            number2 = inputScanner.nextDouble();

            // Use a switch statement to perform the correct operation.
            switch (operator) {
                // Case for addition
                case '+':
                    result = add(number1, number2);
                    System.out.println(number1 + " + " + number2 + " = " + result);
                    break;
                
                // Case for subtraction
                case '-':
                    result = subtract(number1, number2);
                    System.out.println(number1 + " - " + number2 + " = " + result);
                    break;
                
                // Case for multiplication
                case '*':
                    result = multiply(number1, number2);
                    System.out.println(number1 + " * " + number2 + " = " + result);
                    break;

                // Case for division
                case '/':
                    // Check for division by zero.
                    if (number2 != 0) {
                        result = divide(number1, number2);
                        System.out.println(number1 + " / " + number2 + " = " + result);
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                    break;

                default:
                    System.out.println("Invalid operator!");
                    break;
            }
            
            // Ask the user if they want to continue.
            System.out.println("Do you want to perform another calculation? (yes/no)");
            String continueChoice = inputScanner.next();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                break; // Exit the loop if the answer is not "yes".
            }
        }
        
        // Close the scanner to prevent resource leaks.
        inputScanner.close();
        System.out.println("Calculator is closing. Goodbye!");
    }

    /**
     * Adds two numbers.
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The sum of the two numbers.
     */
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    /**
     * Subtracts the second number from the first.
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The difference between the two numbers.
     */
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    /**
     * Multiplies two numbers.
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The product of the two numbers.
     */
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * Divides the first number by the second.
     * @param num1 The numerator.
     * @param num2 The denominator.
     * @return The quotient of the two numbers.
     */
    public static double divide(double num1, double num2) {
        return num1 / num2;
    }
}

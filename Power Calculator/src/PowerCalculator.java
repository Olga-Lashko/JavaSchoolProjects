/*
 * Olga Lashko
 * Programming II
 * CITC-1311-C01
 * 04-10-23
 * Power Calculator
 */
import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from the user
        System.out.print("Enter the value to compute the power for: ");
        int base = scanner.nextInt();
        System.out.print("Enter the value to raise the base to: ");
        int power = scanner.nextInt();

        // Calculate and display the results
        int resultIterative = calculatePowerIterative(base, power);
        int resultRecursive = calculatePowerRecursive(base, power);

        System.out.println("\nRecursive");
        System.out.println(resultRecursive);

        System.out.println("\nIterative");
        System.out.println(resultIterative);

        scanner.close();
    }

    // Iterative method to compute power
    public static int calculatePowerIterative(int base, int power) {
        int result = 1;
        for (int i = 0; i < power; i++) {
            result *= base;
        }
        return result;
    }

    // Recursive method to compute power
    public static int calculatePowerRecursive(int base, int power) {
        if (power == 0) {
            return 1;
        } else {
            return base * calculatePowerRecursive(base, power - 1);
        }
    }
}

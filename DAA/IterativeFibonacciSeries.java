/*
 * Fibonacci Series using Non-Recursive (Iterative) Method
 * --------------------------------------------------------
 * TIME COMPLEXITY:
 * The loop runs from 2 to n → O(n)
 *
 * SPACE COMPLEXITY:
 * Only 3 variables (a, b, c) → O(1)
 *
 * This program:
 * - Accepts 'n' from the user
 * - Prints Fibonacci series up to n terms
 * - Displays nth Fibonacci number
 */

import java.util.*;

public class IterativeFibonacciSeries {

    public static int fib(int n) {

        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0;   // F(0)
        int b = 1;   // F(1)
        int c = 0;   // next Fibonacci number

        // Generate Fibonacci numbers iteratively
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;  // nth Fibonacci number
    }

    public static void printSeries(int n) {
        int a = 0, b = 1;

        System.out.print("Fibonacci Series: ");

        // If n = 1
        if (n >= 1) System.out.print(a + " ");

        // If n = 2
        if (n >= 2) System.out.print(b + " ");

        // Print remaining terms
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }

        System.out.println(); // new line
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms (n): ");
        int n = sc.nextInt();

        // Print Fibonacci series
        printSeries(n);

        // Print nth Fibonacci number
        System.out.println("Fibonacci number at position " + n + " is: " + fib(n));

        sc.close();
    }
}
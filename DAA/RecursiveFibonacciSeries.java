/*
 * Recursive Fibonacci Program
 * ---------------------------
 *
 * TIME COMPLEXITY:
 * Fibonacci recursive relation: T(n) = T(n-1) + T(n-2)
 * → Exponential time = O(2^n)
 *
 * SPACE COMPLEXITY:
 * Recursion stack height = n
 * → O(n)
 *
 * This program:
 * - Accepts 'n' using Scanner
 * - Prints Fibonacci series using recursion
 * - Prints nth Fibonacci number
 */

import java.util.*;

public class RecursiveFibonacciSeries {

    // Recursive function to calculate Fibonacci number
    public static int fib(int n) {
        if (n == 0) return 0;  // Base case
        if (n == 1) return 1;  // Base case

        return fib(n - 1) + fib(n - 2);  // Recursive call
    }

    // Print Fibonacci series up to n terms using recursion
    public static void printSeries(int n) {
        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms (n): ");
        int n = sc.nextInt();

        // Print series
        printSeries(n);

        // Print nth Fibonacci number
        System.out.println("Fibonacci number at position " + n + " is: " + fib(n));

        sc.close();
    }
}
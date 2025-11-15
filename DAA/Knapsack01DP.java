/*
 * 0-1 Knapsack Problem using Dynamic Programming
 * ----------------------------------------------
 *
 * TIME COMPLEXITY:
 * DP table of size (n × W) is filled → O(n * W)
 * where:
 * n = number of items
 * W = knapsack capacity
 *
 * SPACE COMPLEXITY:
 * DP table of size (n × W) → O(n * W)
 *
 * Explanation:
 * - Each item can be taken (1) or not taken (0)
 * - DP[i][w] represents maximum value using first i items with capacity w
 */

import java.util.*;

public class Knapsack01DP {

    public static int knapsack(int[] weight, int[] value, int W, int n) {

        int[][] dp = new int[n + 1][W + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {

                if (weight[i - 1] <= w) {
                    // Choose max of: including item or excluding item
                    dp[i][w] = Math.max(value[i - 1] + dp[i - 1][w - weight[i - 1]],
                                        dp[i - 1][w]);
                } else {
                    // Item cannot be included
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        // Input weights and values
        System.out.println("\nEnter weight and value of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " Weight: ");
            weight[i] = sc.nextInt();

            System.out.print("Item " + (i + 1) + " Value: ");
            value[i] = sc.nextInt();
        }

        // Input capacity
        System.out.print("\nEnter knapsack capacity: ");
        int W = sc.nextInt();

        int maxValue = knapsack(weight, value, W, n);

        System.out.println("\nMaximum value obtainable = " + maxValue);

        sc.close();
    }
}
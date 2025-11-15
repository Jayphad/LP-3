/*
 * Fractional Knapsack Problem using Greedy Strategy
 * --------------------------------------------------
 *
 * GREEDY APPROACH:
 * 1. Calculate value/weight ratio for each item.
 * 2. Sort items in descending order of ratio.
 * 3. Pick items until the knapsack is full.
 * 4. Take fraction of last item if needed.
 *
 * TIME COMPLEXITY:
 * Sorting items by ratio → O(n log n)
 * Looping through items → O(n)
 * Total = O(n log n)
 *
 * SPACE COMPLEXITY:
 * Arrays store n items → O(n)
 */

import java.util.*;

class Item {
    int value, weight;
    double ratio;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight; // value-to-weight ratio
    }
}

public class FractionalKnapsack {

    public static double getMaxValue(Item[] items, int capacity) {
        // Sort items by ratio (value/weight) in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0; // max value we can take
        int currentWeight = 0;

        for (Item item : items) {

            // If full item can be taken
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                totalValue += item.value;
            } 
            else {
                // Take fractional part
                int remain = capacity - currentWeight;
                totalValue += item.ratio * remain;
                break;  // Knapsack is full
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("\nEnter value and weight of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " Value: ");
            int value = sc.nextInt();

            System.out.print("Item " + (i + 1) + " Weight: ");
            int weight = sc.nextInt();

            items[i] = new Item(value, weight);
        }

        // Knapsack capacity
        System.out.print("\nEnter knapsack capacity: ");
        int capacity = sc.nextInt();

        double maxValue = getMaxValue(items, capacity);

        System.out.println("\nMaximum value obtainable = " + maxValue);

        sc.close();
    }
}
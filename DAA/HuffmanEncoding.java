/*
 * Huffman Encoding using Greedy Strategy
 * --------------------------------------
 * TIME COMPLEXITY:
 * Building Priority Queue: O(n)
 * Each extract-min operation: O(log n)
 * Done (n - 1) times → Total = O(n log n)
 *
 * SPACE COMPLEXITY:
 * Priority Queue stores n nodes → O(n)
 * Huffman Tree stores n leaf nodes + internal nodes → O(n)
 * Total Space = O(n)
 *
 * n = number of characters
 */

import java.util.*;

// Node class for Huffman Tree
class Node {
    char ch;            // character
    int freq;           // frequency
    Node left, right;   // links

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

// Comparator for PriorityQueue (min-heap)
class MyComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.freq - b.freq;
    }
}

public class HuffmanEncoding {

    // Recursive function to print Huffman codes
    public static void printCodes(Node root, String code) {
        if (root == null)
            return;

        // Leaf node found
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void buildHuffmanTree(char[] chars, int[] freq) {

        // Step 1: Create Min Heap (PriorityQueue)
        PriorityQueue<Node> pq = new PriorityQueue<>(new MyComparator());

        // Insert all characters into heap
        for (int i = 0; i < chars.length; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        // Step 2: Greedy strategy
        while (pq.size() > 1) {
            // Extract two smallest freq nodes
            Node left = pq.poll();
            Node right = pq.poll();

            // Create new internal node
            Node newNode = new Node('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;

            // Insert back
            pq.add(newNode);
        }

        // Final node is root → print encoded values
        System.out.println("\nHuffman Codes:");
        printCodes(pq.peek(), "");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking number of characters
        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freq = new int[n];

        // Dynamic input for characters and frequencies
        System.out.println("\nEnter characters:");
        for (int i = 0; i < n; i++) {
            chars[i] = sc.next().charAt(0);
        }

        System.out.println("Enter corresponding frequencies:");
        for (int i = 0; i < n; i++) {
            freq[i] = sc.nextInt();
        }

        // Build Huffman Tree and print codes
        buildHuffmanTree(chars, freq);

        sc.close();
    }
}
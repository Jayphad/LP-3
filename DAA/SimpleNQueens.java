import java.util.Scanner;

public class SimpleNQueens {

    // Check if placing queen at (row, col) is safe
    static boolean isSafe(int[][] board, int row, int col, int n) {

        // Check column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    static void solve(int[][] board, int row, int n) {

        // Base case: all queens placed
        if (row == n){
            System.err.println();
             for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
        }
         

        // Try placing queen in each column
        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;    // place queen
                solve(board, row + 1, n);
                board[row][col] = 0;    // backtrack
            }
        }

        // return false; // no valid placement
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N for N Queens: ");
        int n = sc.nextInt();

        int[][] board = new int[n][n];

        solve(board, 0, n);
           

        sc.close();
    }
}
package Backtracking;

public class LC_52 {

    // N-Queens II

    /*The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
    such that no two queens attack each other.
    Given an integer n, return the number of distinct solutions to the n-queens puzzle. */

    public static void main(String[] args) {
        LC_52 obj = new LC_52();
        System.out.println(obj.totalNQueens(4));
    }
    
    int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        backtrack(0, n, cols, diag1, diag2);

        return count;
    }

    // Try to place a queen row by row
    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;
            int d2 = row + col;

            // Check if column or diagonals are already occupied
            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            // Place queen
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row + 1, n, cols, diag1, diag2);

            // Remove queen (backtracking)
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

}

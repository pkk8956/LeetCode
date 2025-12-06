package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_51 {

    //N-Queens

    /*The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
    Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
    queen and an empty space, respectively.*/

     public static void main(String[] args) {
        LC_51 obj = new LC_51(); 
        System.out.println(obj.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

       boolean[] columns = new boolean[n];
       boolean[] diag1 = new boolean[2 * n];
       boolean[] diag2 = new boolean[2 * n];

        backtrack(0, n, board, columns, diag1, diag2, result);

        return result;
    }

    private void backtrack(int row, int n, char[][] board, boolean[] columns, boolean[] diag1, boolean[] diag2, List<List<String>> result) {

        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col ++){
            int d1 = row + col;
            int d2 = row - col + n;
            if (columns[col] || diag1[d1] || diag2[d2]) continue;

            board[row][col] = 'Q';
            columns[col] = diag1[d1] = diag2[d2] = true;

            backtrack(row + 1, n, board, columns, diag1, diag2, result);

            board[row][col] = '.';
            columns[col] = diag1[d1] = diag2[d2] = false;

        }
    }
}

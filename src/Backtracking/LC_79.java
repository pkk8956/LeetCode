package Backtracking;

public class LC_79 {

    //Word Search

    /*Given an m x n grid of characters board and a string word, return true if word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
    or vertically neighboring. The same letter cell may not be used more than once.*/

    public static void main(String[] args) {
        LC_79 obj = new LC_79();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};     
        System.out.println(obj.exist(board, "ABCCED"));
        System.out.println(obj.exist(board, "ABCCED", true));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean result = false;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = backtrack(board, word, visited, i, j, 0);
                    if (result) return true;
                }
            }
        }
        
        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        visited[i][j] = true;
        
        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
            backtrack(board, word, visited, i - 1, j, index + 1) ||
            backtrack(board, word, visited, i, j + 1, index + 1) ||
            backtrack(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }






    public boolean exist(char[][] board, String word, boolean b) {

        int m = board.length, n = board[0].length;
        if (m*n < word.length()) return false;

        char[] wrd = word.toCharArray();
        int[] boardf = new int[128];

        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                ++boardf[board[i][j]];
            }
        }

        for (char ch : wrd){
            if (--boardf[ch] < 0) return false;
        }

        if (boardf[wrd[0]] > boardf[wrd[wrd.length - 1]]) reverse(wrd);

        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (wrd[0] == board[i][j] && found(board, i, j, wrd, new boolean[m][n], 0)) 
                    return true;
            }
        }
        return false;
    }

    private void reverse(char[] word)
    {
        int n = word.length;
        for (int i = 0; i < n/2; ++i){
            char temp = word[i];
            word[i] = word[n - i - 1];
            word[n - i - 1] = temp;
        }
    }

    private static final int[] dirs = {0, -1, 0, 1, 0};

    private boolean found(char[][] board, int row, int col, char[] word, boolean[][] visited, int index){

        if (index == word.length) return true;

        if (row < 0 || col < 0 || row == board.length || col == board[0].length || board[row][col] != word[index] || visited[row][col])
            return false;

        visited[row][col] = true;

        for (int i = 0; i < 4; ++i){
            if (found(board, row + dirs[i], col + dirs[i + 1], word, visited, index + 1))
                return true;
        }
        visited[row][col] = false;
        return false;
    }
}

package Matrix;

public class LC_36 {

    //Valid Sudoku

    /*Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.*/

    public static void main(String[] args) {
        LC_36 obj = new LC_36();
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(obj.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        //Use arrays to track the presence of numbers in rows, columns, and boxes
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        //Iterate through each cell in the board
        for (int i = 0; i < 9; i++) {
            //Check each column in the current row
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                //If the cell is not empty
                if (c != '.') {
                    int num = c - '1'; //Convert char to int (0-8)
                    int boxIndex = (i / 3) * 3 + (j / 3); //Calculate box index

                    //Check for duplicates in row, column, and box
                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                        return false;
                    }

                    //Mark the number as seen in the respective row, column, and box
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }
        return true; //No duplicates found, the board is valid
    }
    
}

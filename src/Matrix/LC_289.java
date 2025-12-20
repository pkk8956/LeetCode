package Matrix;

public class LC_289 {

    //Game of Life

    /*According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
    is a cellular automaton devised by the British mathematician John Horton Conway in 1970.
    The board is made up of an m x n grid of cells, where each cell has an initial state: 
    live (represented by a 1) or dead (represented by a 0). Each cell interacts with its 
    eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
        -- Any live cell with fewer than two live neighbors dies as if caused by under-population.
        -- Any live cell with two or three live neighbors lives on to the next generation.
        -- Any live cell with more than three live neighbors dies, as if by over-population.
        -- Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    The next state is created by applying the above rules simultaneously to every cell in the 
    current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.*/

    public static void main(String[] args) {
        LC_289 obj = new LC_289();
        int[][] board = {
            {0,1,0},
            {0,0,1},
            {1,1,1},
            {0,0,0}
        };
        obj.gameOfLife(board);
        System.out.println("Next State:");
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public void gameOfLife(int[][] board) {
        //Directions for the 8 neighbors
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        int rows = board.length;
        int cols = board[0].length;

        //Create a copy of the original board to reference the current state
        int[][] copyBoard = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(board[i], 0, copyBoard[i], 0, cols);
        }

        //Update each cell based on the Game of Life rules
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int liveNeighbors = 0;

                //Count live neighbors
                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                        liveNeighbors += copyBoard[newRow][newCol];
                    }
                }

                //Apply the rules
                if (copyBoard[r][c] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[r][c] = 0; //Cell dies
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[r][c] = 1; //Cell becomes alive
                    }
                }
            }
        }
    }
    
}

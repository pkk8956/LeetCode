package Graph;

import java.util.ArrayDeque;

public class LC_909 {

    //Snakes and Ladders

    /*You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style 
    starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.
    You start on square 1 of the board. In each move, starting from square curr, do the following:
    Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
        -- This choice simulates the result of a standard 6-sided die roll: i.e., there are always at 
        most 6 destinations, regardless of the size of the board.
        -- If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
        -- The game ends when you reach the square n2.
    A board square on row r and column c has a snake or ladder if board[r][c] != -1. 
    The destination of that snake or ladder is board[r][c]. Squares 1 and n2 are not the starting points of any snake or ladder.
    Note that you only take a snake or ladder at most once per dice roll. If the destination to a snake 
    or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.
    For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. 
    You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
    Return the least number of dice rolls required to reach the square n2. If it is not possible to reach the square, return -1. */

    public static void main(String[] args) {
        LC_909 obj = new LC_909();
        int[][] board = {{-1,-1,-1,-1,-1,-1},
                         {-1,-1,-1,-1,-1,-1},
                         {-1,-1,-1,-1,-1,-1},
                         {-1,35,-1,-1,13,-1},
                         {-1,-1,-1,-1,-1,-1},
                         {-1,15,-1,-1,-1,-1}};
        System.out.println(obj.snakesAndLadders(board));
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;

        boolean[] visited = new boolean[target + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;

        int moves = 0;

        // BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == target) return moves;

                // Try all dice outcomes
                for (int next = curr + 1; next <= Math.min(curr + 6, target); next++) {

                    int dest = getDestination(board, next, n);

                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private int getDestination(int[][] board, int num, int n) {
        int r = (num - 1) / n;
        int c = (num - 1) % n;

        int row = n - 1 - r;
        int col = (r % 2 == 0) ? c : (n - 1 - c);

        // Return snake/ladder destination if exists
        return board[row][col] == -1 ? num : board[row][col];
    }
    
}

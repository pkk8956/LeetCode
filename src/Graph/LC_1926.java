package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class LC_1926 {

    // Nearest Exit from Entrance in Maze

    /* You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+').
    You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column 
    of the cell you are initially standing at.
    In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze.
    Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze.
    The entrance does not count as an exit.
    Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.*/

    public static void main(String[] args) {
        LC_1926 obj = new LC_1926();
        char[][] maze = {
            {'+','+','.','+'},
            {'.','.','.','+'},
            {'+','+','+','.'}
        };
        int[] entrance = {1, 2};
        int result = obj.nearestExit(maze, entrance);
        System.out.println("Nearest exit steps: " + result);
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});

        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}}; 

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1], steps = curr[2];

            if ((row == 0 || row == m-1 || col == 0 || col == n-1) &&
                 !(row == entrance[0] && col == entrance[1])) {
                return steps;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                    !visited[newRow][newCol] && maze[newRow][newCol] == '.') {
                    queue.offer(new int[]{newRow, newCol, steps + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1; 
    }
}

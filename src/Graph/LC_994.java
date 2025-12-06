package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC_994 {

    //Rotting Oranges

    /*You are given an m x n grid where each cell can have one of three values:
        0 representing an empty cell,
        1 representing a fresh orange, or
        2 representing a rotten orange.
    Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
    Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.*/

    public static void main(String[] args) {
        LC_994 obj = new LC_994();  
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
            
        System.out.println(obj.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) queue.offer(new int[]{r, c});
                else if (grid[r][c] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int minutes = 0;

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1];

                for (int j = 0; j < 4; j++) {
                    int nr = r + dr[j], nc = c + dc[j];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}

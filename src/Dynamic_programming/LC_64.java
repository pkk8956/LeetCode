package Dynamic_programming;

public class LC_64 {

    //Minimum Path Sum

    /*Given a m x n grid filled with non-negative numbers, find a path from top left 
    to bottom right, which minimizes the sum of all numbers along its path.
    Note: You can only move either down or right at any point in time.*/

    public static void main(String[] args) {
        LC_64 obj = new LC_64();  
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
            
        System.out.println(obj.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];

        dp[0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }

        return dp[n - 1];
    }
}

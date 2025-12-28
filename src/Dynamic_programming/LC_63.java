package Dynamic_Programming;

public class LC_63 {

    //Unique Paths II

    /*You are given an m x n integer array grid. There is a robot initially 
    located at the top-left corner (i.e., grid[0][0]). The robot tries to move 
    to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can 
    only move either down or right at any point in time.
    An obstacle and space are marked as 1 or 0 respectively in grid. 
    A path that the robot takes cannot include any square that is an obstacle.
    Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
    The testcases are generated so that the answer will be less than or equal to 2 * 109. */

    public static void main(String[] args) {
        LC_63 obj = new LC_63();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}

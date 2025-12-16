package Dynamic_Programming;

public class LC_62 {

    //Unique Paths

    /*There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
    The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
    The robot can only move either down or right at any point in time.
    Given the two integers m and n, return the number of possible unique paths 
    that the robot can take to reach the bottom-right corner.*/

    public static void main(String[] args) {
        LC_62 obj = new LC_62();  
            
        System.out.println(obj.uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}

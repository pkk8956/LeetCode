package Dynamic_Programming;

public class LC_790 {

    //Domino and Tromino Tiling

    /*You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
    Given an integer n, return the number of ways to tile an 2 x n board.
    Since the answer may be very large, return it modulo 10^9 + 7.*/

    public static void main(String[] args) {
        LC_790 obj = new LC_790();
        System.out.println(obj.numTilings(3));
    }

    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] dp = new long[n + 1];
        long[] dp2 = new long[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp2[2] = 1; // ways to tile 2 x 2 board with one square missing

        for (int i = 3; i <= n; i++) {
            dp2[i] = (dp2[i - 1] + dp[i - 2]) % MOD;
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * dp2[i - 1]) % MOD;
        }

        return (int) dp[n];
    }
}
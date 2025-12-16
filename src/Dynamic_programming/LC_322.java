package Dynamic_Programming;

import java.util.Arrays;

public class LC_322 {

    //Coin Change

    /*You are given an integer array coins representing coins of different denominations and 
    an integer amount representing a total amount of money.
    Return the fewest number of coins that you need to make up that amount. If that amount 
    of money cannot be made up by any combination of the coins, return -1.
    You may assume that you have an infinite number of each kind of coin.*/

    public static void main(String[] args) {
        LC_322 obj = new LC_322(); 
        int[] coins = {1, 2, 5};
        System.out.println(obj.coinChange(coins, 11));
    }

    public int coinChange(int[] coins, int amount) {
        int MAX = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

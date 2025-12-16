package Dynamic_Programming;

public class LC_714 {

    //Best Time to Buy and Sell Stock with Transaction Fee

    /*You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
    Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
        Note:
        -- You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
        -- The transaction fee is only charged once for each stock purchase and sale. */

        public static void main(String[] args) {
            LC_714 obj = new LC_714();
            int[] prices = {1, 3, 2, 8, 4, 9};
            int fee = 2;
            System.out.println(obj.maxProfit(prices, fee));
        }

        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[][] dp = new int[n][2];

            dp[0][0] = 0; 
            dp[0][1] = -prices[0]; 

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }
}

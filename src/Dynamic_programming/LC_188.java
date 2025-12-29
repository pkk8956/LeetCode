package Dynamic_Programming;

public class LC_188 {
    
    //Best Time to Buy and Sell Stock IV

    /*You are given an integer array prices where prices[i] is the 
    price of a given stock on the ith day, and an integer k.
    Find the maximum profit you can achieve. You may complete at
     most k transactions: i.e. you may buy at most k times and sell at most k times.
    Note: You may not engage in multiple transactions simultaneously 
    (i.e., you must sell the stock before you buy again). */

    public static void main(String[] args) {
        LC_188 obj = new LC_188();
        int k = 2;
        int[] prices = {2,4,1};
        System.out.println(obj.maxProfit(k, prices));
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // optimization: same as unlimited transactions
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        for (int i = 1; i <= k; i++) {
            buy[i] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }

        return sell[k];
    }
}

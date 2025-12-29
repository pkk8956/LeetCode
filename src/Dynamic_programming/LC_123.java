package Dynamic_Programming;

public class LC_123 {

    // Best Time to Buy and Sell Stock III

    /*You are given an array prices where prices[i] is the price of a given stock on the ith day.
    Find the maximum profit you can achieve. You may complete at most two transactions.
    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again). */

    public static void main(String[] args) {
       LC_123 obj = new LC_123();
       int[] prices = {3,3,5,0,0,3,1,4};
       System.out.println(obj.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);

            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }
}

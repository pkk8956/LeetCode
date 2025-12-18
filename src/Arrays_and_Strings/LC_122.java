package Arrays_and_Strings;

public class LC_122 {

    // Best Time to Buy and Sell Stock II

    /* You are given an array prices where prices[i] is the price of a given stock 
    on the ith day. On each day, you may decide to buy and/or sell the stock. 
    You can only hold at most one share of the stock at any time. However, you 
    can buy it then immediately sell it on the same day. Find and return the 
    maximum profit you can achieve. */

    public static void main(String[] args) {
        LC_122 obj = new LC_122();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(obj.maxProfit(prices)); // Output: 7
    }

    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        // Iterate through the prices array
        for(int i=1;i<prices.length;i++){
            // If selling today is profitable, add to total profit
            if (prices[i-1] < prices[i]) {
                totalProfit += prices[i] - prices[i-1];
            }
        }
        return totalProfit;
    }
}

package Greedy;

public class LC_121 {

    //Best Time to Buy and Sell Stock

    /*You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.*/

    public static void main(String[] args) {
        LC_121 obj = new LC_121();  
        int[] prices = {7,1,5,3,6,4};
        System.out.println(obj.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) minPrice = price;
            else {
                int profit = price - minPrice;
                if (profit > maxProfit) maxProfit = profit;
            }
        }
        return maxProfit;
    }

}

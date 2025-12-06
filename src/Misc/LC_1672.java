package Misc;

public class LC_1672 {

    //Richest Customer Wealth

    /*You are given an m x n integer grid accounts where accounts[i][j] is the amount of money
    the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.
    A customer's wealth is the amount of money they have in all their bank accounts. The richest 
    customer is the customer that has the maximum wealth.*/

    public static void main(String[] args) {
        LC_1672 obj = new LC_1672();      
        System.out.println(obj.maximumWealth(new int[][] {{1,2,3},{3,2,1}}));
    }

    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for(int i=0; i<accounts.length; i ++){
            int wealth = 0;

            for(int j=0; j<accounts[i].length; j ++){
                wealth +=accounts[i][j];
            }
            maxWealth = wealth>maxWealth ? wealth : maxWealth;

        }
        return maxWealth;
    }
}

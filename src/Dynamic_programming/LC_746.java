package Dynamic_Programming;

public class LC_746 {

    //Min Cost Climbing Stairs

    /*You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
    Once you pay the cost, you can either climb one or two steps.
    You can either start from the step with index 0, or the step with index 1.
    Return the minimum cost to reach the top of the floor.*/

    public static void main(String[] args) {
        LC_746 obj = new LC_746();
        int[] cost = {10, 15, 20};
        System.out.println(obj.minCostClimbingStairs(cost)); 
    }

    public int minCostClimbingStairs(int[] cost) {
        int prev2 = 0, prev1 = 0;
        for (int i = 2; i <= cost.length; i++) {
            int curr = Math.min(prev1 + cost[i-1], prev2 + cost[i-2]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

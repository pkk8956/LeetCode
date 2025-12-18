package Arrays_and_Strings;

public class LC_134 {

    // Gas Station

    /* There are n gas stations along a circular route, where the amount of gas at 
    the ith station is gas[i]. You have a car with an unlimited gas tank and it 
    costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. 
    You begin the journey with an empty tank at one of the gas stations.  
    Given two integer arrays gas and cost, return the starting gas station's index 
    if you can travel around the circuit once in the clockwise direction, otherwise return -1. 
    If there exists a solution, it is guaranteed to be unique */

    public static void main(String[] args) {
        LC_134 obj = new LC_134();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(obj.canCompleteCircuit(gas, cost)); // Output: 3
    }



    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Total gas and cost to check if a solution is possible
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startingStation = 0;

        // Iterate through each gas station
        for (int i = 0; i < gas.length; i++) {
            // Update total gas and cost
            totalGas += gas[i];
            totalCost += cost[i];
            // Update current gas in tank
            currentGas += gas[i] - cost[i];

            // If current gas is negative, reset starting station and current gas
            if (currentGas < 0) {
                startingStation = i + 1;
                currentGas = 0;
            }
        }

        // If total gas is less than total cost, return -1
        return totalGas < totalCost ? -1 : startingStation;
    }
    
}

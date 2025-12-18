package Arrays_and_Strings;

import java.util.Arrays;

public class LC_135 {

    // Candy

    /* There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
    You are giving candies to these children subjected to the following requirements:
    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    Return the minimum number of candies you need to have to distribute the candies to the children.*/

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        LC_135 obj = new LC_135();
        System.out.println(obj.candy(ratings));
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int totalCandies = 0;
        int[] candies = new int[n];

        // Step 1: Initialize all children with 1 candy
        Arrays.fill(candies, 1); 
        
        // Step 2: Left to right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // Step 3: Right to left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        // Step 4: Calculate total candies needed
        for (int candy : candies) {
            totalCandies += candy;
        }
        return totalCandies;
    }
    
}

package Randomised_Algorithms;

import java.util.Random;

public class MonteCarloMin {

    // Monte Carlo algorithm to find the minimum element in an array

    /* This algorithm randomly samples elements from the array and keeps track of the smallest one found so far. */

    private static final Random random = new Random();

    public static int findMin(int[] arr, int samples) {
        int min = arr[random.nextInt(arr.length)];

        for (int i = 1; i < samples; i++) {
            int value = arr[random.nextInt(arr.length)];
            if (value < min) min = value;
        }

        return min;
    }
}

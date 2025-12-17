package Randomised_Algorithms;

import java.util.Random;

public class LasVegasMin {

    // Las Vegas algorithm to find the minimum element in an array

    /* This algorithm randomly selects elements from the array and verifies if they are the minimum.
       It continues this process until it finds the actual minimum element. */

    private static final Random random = new Random();

    public static int findMin(int[] arr) {
        while (true) {
            int candidate = arr[random.nextInt(arr.length)];
            boolean isMin = true;

            for (int value : arr) {
                if (value < candidate) {
                    isMin = false;
                    break;
                }
            }

            if (isMin) return candidate;
        }
    }
}

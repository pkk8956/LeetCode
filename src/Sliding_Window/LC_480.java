package Sliding_Window;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC_480 {

    //Sliding Window Median

    /*The median is the middle value in an ordered integer list. If the size of the list is even, 
    there is no middle value. So the median is the mean of the two middle values.
        - For examples, if arr = [2,3,4], the median is 3.
        - For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
    You are given an integer array nums and an integer k. There is a sliding window of size k 
    hich is moving from the very left of the array to the very right. You can only see the k numbers 
    in the window. Each time the sliding window moves right by one position.
    Return the median array for each window in the original array. 
    Answers within 10-5 of the actual value will be accepted.*/

    public static void main(String[] args) {
        LC_480 obj = new LC_480();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] result = obj.medianSlidingWindow(nums, k);
        for (double num : result) {
            System.out.print(num + " ");
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> delayed = new HashMap<>();
        int n = nums.length;
        double[] result = new double[n - k + 1];
        int balance = 0;

        // Helper functions ------------
        Runnable pruneMax = () -> {
            while (!maxHeap.isEmpty() && delayed.getOrDefault(maxHeap.peek(), 0) > 0) {
                int x = maxHeap.poll();
                delayed.put(x, delayed.get(x) - 1);
            }
        };

        Runnable pruneMin = () -> {
            while (!minHeap.isEmpty() && delayed.getOrDefault(minHeap.peek(), 0) > 0) {
                int x = minHeap.poll();
                delayed.put(x, delayed.get(x) - 1);
            }
        };

        // Insert first k elements
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty() || nums[i] <= maxHeap.peek()) {
                maxHeap.add(nums[i]);
                balance++;
            } else {
                minHeap.add(nums[i]);
                balance--;
            }
     }

        // Rebalance heaps
        while (balance > 1) {
            minHeap.add(maxHeap.poll());
            balance -= 2;
        }
        while (balance < 0) {
            maxHeap.add(minHeap.poll());
            balance += 2;
        }

        pruneMax.run();
        pruneMin.run();

        // Get first median
        result[0] = (k % 2 == 1) ? maxHeap.peek() : ((maxHeap.peek() / 2.0) + (minHeap.peek() / 2.0));

        // Sliding window
        for (int i = k; i < n; i++) {
            int add = nums[i];
            int remove = nums[i - k];
            // Determine where to remove from
            if (remove <= maxHeap.peek()) balance--;
            else balance++;
            delayed.put(remove, delayed.getOrDefault(remove, 0) + 1);
            // Add new element
            if (maxHeap.isEmpty() || add <= maxHeap.peek()) {
                maxHeap.add(add);
                balance++;
            } else {
                minHeap.add(add);
                balance--;
            }
            // Rebalance heaps
            if (balance > 1) {
                minHeap.add(maxHeap.poll());
                balance -= 2;
                pruneMax.run();
            } else if (balance < 0) {
                maxHeap.add(minHeap.poll());
                balance += 2;
                pruneMin.run();
            }
            pruneMax.run();
            pruneMin.run();
            // Calculate median
            if (k % 2 == 1)result[i - k + 1] = maxHeap.peek();
            else result[i - k + 1] = ((maxHeap.peek() / 2.0) + (minHeap.peek() / 2.0));
        }
        return result;
    }
}

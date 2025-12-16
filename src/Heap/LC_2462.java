package Heap;

public class LC_2462 {

    // Total Cost to Hire K Workers

    /* You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the i-th worker.
       You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:
       - You will run k sessions and hire exactly one worker in each session.
       - In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers.
       - If there is a tie, the worker with the smallest index is chosen.
       - Remove the chosen worker from the pool of available workers.
       - If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them.
       Return the total cost to hire exactly k workers.*/

    public static void main(String[] args) {
        LC_2462 obj = new LC_2462();
        int[] costs = {17,12,10,2,7,2,11,20,8};
        int k = 3;
        int candidates = 4;
        System.out.println(obj.totalCost(costs, k, candidates));

    }

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        java.util.PriorityQueue<int[]> minHeap = new java.util.PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );

        int left = 0, right = n - 1;

        for (int i = 0; i < candidates && left <= right; i++) {
            minHeap.offer(new int[]{costs[left], left});
            left++;
        }

        for (int i = 0; i < candidates && left <= right; i++) {
            minHeap.offer(new int[]{costs[right], right});
            right--;
        }

        long totalCost = 0;

        for (int hire = 0; hire < k; hire++) {
            int[] worker = minHeap.poll();
            totalCost += worker[0];

            if (left <= right) {
                if (worker[1] < left) {
                    minHeap.offer(new int[]{costs[left], left});
                    left++;
                } else {
                    minHeap.offer(new int[]{costs[right], right});
                    right--;
                }
            }
        }

        return totalCost;
    }
    
}

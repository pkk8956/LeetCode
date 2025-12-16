package Heap;

public class LC_2542 {
    
    // Maximum Subsequence Score

    /* You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k.
       You must choose a subsequence of indices from nums1 of length k.
       For chosen indices i0, i1, ..., ik - 1, your score is defined as:
       The sum of the selected elements from nums1 multiplied by the minimum of the selected elements from nums2.
       Return the maximum possible score.*/


    public static void main(String[] args) {
        LC_2542 obj = new LC_2542();
        int[] nums1 = {1,3,3,2};
        int[] nums2 = {2,1,3,4};
        int k = 3;
        System.out.println(obj.maxScore(nums1, nums2, k)); 
    }


    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        java.util.Arrays.sort(indices, (a, b) -> Integer.compare(nums2[b], nums2[a]));

        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;

        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            minHeap.offer(nums1[idx]);
            sum += nums1[idx];

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                long currentScore = sum * nums2[idx];
                maxScore = Math.max(maxScore, currentScore);
            }
        }

        return maxScore;
    }
}

package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC_373 {

    //Find K Pairs with Smallest Sums

    /*You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
    Define a pair (u, v) which consists of one element from the first array and one element from the second array.
    Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums. */

    public static void main(String[] args) {
        LC_373 obj = new LC_373();
        int[] nums1 = {1,7,11}, nums2 = {2,4,6};
        int k = 3;
        List<List<Integer>> result = obj.kSmallestPairs(nums1, nums2, k);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        // Min-heap: {sum, i, j}
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Initialize heap with pairs (nums1[i], nums2[0])
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            heap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k > 0 && !heap.isEmpty()) {
            int[] curr = heap.poll();
            int i = curr[1], j = curr[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                heap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }

            k--;
        }

        return result;
    }
}

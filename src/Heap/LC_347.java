package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC_347 {

    //Top K Frequent Elements

    /*Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.*/

    public static void main(String[] args) {
        LC_347 obj = new LC_347();  
        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        System.out.println(obj.topKFrequent(nums, 2));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            minHeap.offer(new int[]{e.getKey(), e.getValue()});
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) ans[i] = minHeap.poll()[0];
        return ans;
    }
}

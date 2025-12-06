package Heap;

import java.util.PriorityQueue;

public class LC_215 {

    //Kth Largest Element in an Array

    /*Given an integer array nums and an integer k, return the kth largest element in the array.
    Note that it is the kth largest element in the sorted order, not the kth distinct element.*/

    public static void main(String[] args) {
        LC_215 obj = new LC_215();  
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(obj.findKthLargest(nums, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

}

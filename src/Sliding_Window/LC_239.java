package Sliding_Window;

import java.util.Deque;
import java.util.LinkedList;

public class LC_239 {
    //Sliding Window Maximum

    /*You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
    You can only see the k numbers in the window. Each time the sliding window moves right by one position.
    Return the max sliding window.*/

    public static void main(String[] args) {
        LC_239 obj = new LC_239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = obj.maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

   public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // храним индексы

        for (int i = 0; i < n; i++) {

            // 1. Удаляем элементы слева, которые выходят из окна
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 2. Удаляем элементы справа, которые меньше текущего
            // они уже бесполезны — максимумом не станут
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // 3. Добавляем текущий индекс
            deque.offerLast(i);

            // 4. Когда окно достигло размера k — записываем максимум
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}

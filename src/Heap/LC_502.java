package Heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_502 {

    // IPO

    /*Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, 
    LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, 
    it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its 
    otal capital after finishing at most k distinct projects.
    You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
    Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will 
    be added to your total capital.
    Pick a list of at most k distinct projects from given projects to maximize your final 
    capital, and return the final maximized capital.
    The answer is guaranteed to fit in a 32-bit signed integer. */

    public static void main(String[] args) {
        LC_502 obj = new LC_502();
        int k = 2, w = 0; 
        int[] profits ={1,2,3}, capital = {0,1,1};
        System.out.println(obj.findMaximizedCapital(k, w, profits, capital));
    }

     public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Min-heap by required capital
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }

        // Max-heap by profit
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            // Move all projects that can be started to maxProfitHeap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll()[1]);
            }

            if (maxProfitHeap.isEmpty()) {
                // No projects can be started
                break;
            }

            // Pick the project with maximum profit
            w += maxProfitHeap.poll();
        }

        return w;
    }
    
}

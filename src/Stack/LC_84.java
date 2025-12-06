package Stack;

import java.util.ArrayDeque;

public class LC_84 {

    //Largest Rectangle in Histogram

    /*Given an array of integers heights representing the histogram's bar height where 
    the width of each bar is 1, return the area of the largest rectangle in the histogram.*/

    public static void main(String[] args) {
        LC_84 obj = new LC_84();
        int[] heights  = {2,1,5,6,2,3};
        System.out.println(obj.largestRectangleArea(heights));        
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            
            int h = (i == n ? 0 : heights[i]);

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = right - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

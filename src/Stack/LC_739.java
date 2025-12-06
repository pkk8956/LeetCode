package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class LC_739 {  

    //Daily Temperatures

    /*Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] 
    is the number of days you have to wait after the ith day to get a warmer temperature. 
    If there is no future day for which this is possible, keep answer[i] == 0 instead.*/

    public static void main(String[] args) {
        LC_739 obj = new LC_739();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(obj.dailyTemperatures(temperatures)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) stack.pop();
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
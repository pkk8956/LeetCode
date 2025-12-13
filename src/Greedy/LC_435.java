package Greedy;

import java.util.Arrays;

public class LC_435 {

    //Non-overlapping Intervals

    /*Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number 
    of intervals you need to remove to make the rest of the intervals non-overlapping.*/
    

    public static void main(String[] args) {
        LC_435 obj = new LC_435();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(obj.eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) count++;
            else end = intervals[i][1];
        }
        return count;
    }
}

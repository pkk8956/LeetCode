package Arrays_and_Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_57 {

    // Insert Interval

    /*You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent 
    the start and the end of the ith interval and intervals is sorted in ascending order by starti. 
    You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals 
    still does not have any overlapping intervals (merge overlapping intervals if necessary).
    Return intervals after the insertion. */

    public static void main(String[] args) {
        LC_57 obj = new LC_57();
        int[][] intervals =  {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = obj.insert(intervals, newInterval);
        for (int[] arr : result) System.out.println(Arrays.toString(arr));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}

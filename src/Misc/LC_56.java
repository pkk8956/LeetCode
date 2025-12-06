package Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_56 {

    //Merge Intervals

    /*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
    and return an array of the non-overlapping intervals that cover all the intervals in the input.*/

    public static void main(String[] args) {
        LC_56 obj = new LC_56();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = obj.merge(intervals);
        for (int[] interval : merged) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}

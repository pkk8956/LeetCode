package Hash_Map;

import java.util.HashSet;
import java.util.Set;

public class LC_128 {

    //Longest Consecutive Sequence

    /*Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    You must write an algorithm that runs in O(n) time.*/

    public static void main(String[] args) {
        LC_128 obj = new LC_128();  
        int[] nums = {100,4,200,1,3,2};
        System.out.println(obj.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int streak = 1;
                while (set.contains(current + 1)) {
                    current++;
                    streak++;
                }
                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }

}

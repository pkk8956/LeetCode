package Greedy;

import java.util.ArrayList;
import java.util.List;

public class LC_763 {

    //Partition Labels

    /*You are given a string s. We want to partition the string into as many parts as possible 
    so that each letter appears in at most one part. For example, the string "ababcc" can be 
    partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.
    Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
    Return a list of integers representing the size of these parts.*/

    public static void main(String[] args) {
        LC_763 obj = new LC_763();  
        System.out.println(obj.partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0; 
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }

}

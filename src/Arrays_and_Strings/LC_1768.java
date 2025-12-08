package Arrays_and_Strings;


public class LC_1768 {

    //Merge Strings Alternately

    /*You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, 
    starting with word1. If a string is longer than the other, append the additional letters onto the end 
    of the merged string. Return the merged string. */

    public static void main(String[] args) {
        LC_1768 obj = new LC_1768();
        String word1 = "abc", word2 = "pqr";
        System.out.println(obj.mergeAlternately(word1, word2));
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) sb.append(word1.charAt(i++));
            if (j < word2.length()) sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}
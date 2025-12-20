package Hash_Map;

public class LC_242 {

    // Valid Anagram

    /* Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once. */

    public static void main(String[] args) {
        LC_242 obj = new LC_242();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(obj.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        //Edge case 
        if (s.length() != t.length()) return false;
        //Using array to count frequency of characters
        int[] count = new int[26];

        //Incrementing count for characters in s and decrementing for characters in t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        //If all counts are zero, then t is an anagram of s
        for (int c : count) if (c != 0) return false;
        return true;
    }
    
}

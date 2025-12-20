package Sliding_Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_30 {
    
    //Substring with Concatenation of All Words

    /*You are given a string s and an array of strings words of the same length. 
    Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, 
    in any order, and without any intervening characters.
    You can return the answer in any order.*/

    public static void main(String[] args) {
        LC_30 obj = new LC_30();
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(obj.findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        //Sliding Window Approach
        List<Integer> result = new ArrayList<>();
        //Edge cases
        if (s == null || words == null || words.length == 0) return result;

        //Create a map of words and their frequencies
        int wordLength = words[0].length();
        int wordCount = words.length;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String w : words) wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);

        //Slide over the string in wordLength increments
        for (int i = 0; i < wordLength; i++) {
            //Initialize pointers and count
            int left = i, right = i, count = 0;
            //Create a map to keep track of words in the current window
            Map<String, Integer> window = new HashMap<>();

            //Expand the window by moving the right pointer
            while (right + wordLength <= s.length()) {
                //Get the next word from the string
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                //If the word is not in the word map, reset the window
                if (!wordMap.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right;
                    continue;
                }

                //Add the word to the window
                window.put(word, window.getOrDefault(word, 0) + 1);
                count++;

                //If the word frequency exceeds the required frequency, shrink the window from the left
                while (window.get(word) > wordMap.get(word)) {
                    //Remove the leftmost word from the window
                    String leftWord = s.substring(left, left + wordLength);
                    //Decrease its frequency
                    window.put(leftWord, window.get(leftWord) - 1);
                    left += wordLength;
                    count--;
                }
                //If the count matches the number of words, we found a valid starting index

                if (count == wordCount) result.add(left);
            }
        }
        return result;
    }
}


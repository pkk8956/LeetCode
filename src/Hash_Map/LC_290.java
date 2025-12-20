package Hash_Map;

import java.util.Map;

public class LC_290 {

    // Word Pattern

    /*Given a pattern and a string s, determine if s matches the pattern. 
    A string s matches a pattern if there is a bijection between a letter in pattern and a non-empty word in s. 
    Example: pattern = "abba", s = "dog cat cat dog" */

    public static void main(String[] args) {
        LC_290 obj = new LC_290();
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(obj.wordPattern(pattern, s)); 
    }

    public boolean wordPattern(String pattern, String s) {
        // Split the string into words
        String[] words = s.split(" ");
        //Edge case: if lengths don't match, return false
        if (pattern.length() != words.length) return false;

        // Create two maps for bijection
        Map<Character, String> charToWord = new java.util.HashMap<>();
        Map<String, Character> wordToChar = new java.util.HashMap<>();

        // Iterate through the pattern and words
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            // Check the mappings in both directions
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(w)) return false;
            // Mapped word does not match
            } else {
                // Map the character to the word
                charToWord.put(c, w);
            }

            // Check the reverse mapping
            if (wordToChar.containsKey(w)) {
                // Mapped character does not match
                if (wordToChar.get(w) != c) return false;
                // Map the word to the character
            } else {
                wordToChar.put(w, c);
            }
        }
        return true;
    }
}

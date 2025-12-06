package Misc;

import java.util.HashMap;

public class LC_383 {

    //Ransom Note

    /*Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using 
    the letters from magazine and false otherwise.
    Each letter in magazine can only be used once in ransomNote.*/

    public static void main(String[] args) {
        LC_383 obj = new LC_383();      
        System.out.println(obj.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c: magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) == 0) return false;
            map.put(c, map.get(c) - 1);
        }
        
        return true;
    }
}

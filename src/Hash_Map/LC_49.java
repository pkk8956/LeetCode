package Hash_Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_49 {

    //Group Anagrams

    /*Given an array of strings strs, group the anagrams together. You can return the answer in any order.*/

    public static void main(String[] args) {
        LC_49 obj = new LC_49();  
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(obj.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

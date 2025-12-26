package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_17 {

    //Letter Combinations of a Phone Number

    /*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
    Return the answer in any order.
    A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.*/

    public static void main(String[] args) {
        LC_17 obj = new LC_17();      
        System.out.println(obj.letterCombinations("234"));
    }

    public List<String> letterCombinations(String digits) {
        
        if (digits.isEmpty()) return Collections.emptyList();

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        backtrack(result, map, digits, new StringBuilder(), 0);

        return result;
    }

    private void backtrack(List<String> result, Map<Character, String> map, String digits, StringBuilder path, int index) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            path.append(letter);
            backtrack(result, map, digits, path, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

}

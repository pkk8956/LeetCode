package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_20 {

    //Valid Parentheses

    /*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:
        - Open brackets must be closed by the same type of brackets.
        - Open brackets must be closed in the correct order.
        - Every close bracket has a corresponding open bracket of the same type.*/

        public static void main(String[] args) {
            LC_20 obj = new LC_20();
            String s = "()[]{}";
            System.out.println(obj.isValid(s));
        }
    
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': stack.push(')');
                    break;
                case '{': stack.push('}');
                    break;
                case '[': stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
    }
}

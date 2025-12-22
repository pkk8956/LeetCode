package Stack;

import java.util.Stack;

public class LC_224 {

    //Basic Calculator

    /*Given a string s representing a valid expression, implement a 
    basic calculator to evaluate it, and return the result of the evaluation. */

    public static void main(String[] args) {
        LC_224 obj = new LC_224();
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(obj.calculate(s));
    }

    public int calculate(String s) {
        int result = 0; int sign = 1;   
        int n = s.length(); int i = 0;
        Stack<Integer> stack = new Stack<>();
        
        while (i < n) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
             int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
            result += sign * num;
            continue; 
            } 
              else if (c == '+') sign = 1;
              else if (c == '-') sign = -1;
              else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = prevResult + prevSign * result;
            }
            i++;
        }
        return result;
    }
}

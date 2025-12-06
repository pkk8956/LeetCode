package Misc;

import java.util.ArrayList;
import java.util.List;

public class LC_412 {

    //Fizz Buzz

    /*Given an integer n, return a string array answer (1-indexed) where:
    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.*/

    public static void main(String[] args) {
        LC_412 obj = new LC_412();      
        System.out.println(obj.fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {
       List<String> answer = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            if (i % 3 == 0) sb.append("Fizz");
            if (i % 5 == 0) sb.append("Buzz");
            answer.add(sb.length() > 0 ? sb.toString(): Integer.toString(i));
        }
        
        return answer;
    }
}

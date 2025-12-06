package Dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class LC_118 {

    //Pascal's Triangle

    /*iven an integer numRows, return the first numRows of Pascal's triangle.
    In Pascal's triangle, each number is the sum of the two numbers directly above it.*/

    public static void main(String[] args) {
        LC_118 obj = new LC_118();  
            
        System.out.println(obj.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);

            if (i > 0) {
                List<Integer> prev = res.get(i - 1);
                for (int j = 1; j < i; j++) {
                    row.add(prev.get(j - 1) + prev.get(j));
                }
                row.add(1);
            }

            res.add(row);
        }

        return res;
    }

}

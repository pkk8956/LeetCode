package Hash_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LC_2352 {

    //Equal Row and Column Pairs

    /*Given a 0-indexed n x n integer matrix grid, return the number of pairs (Ri, Cj) such that row Ri and column Cj are equal.
    A row and column pair is considered equal if they contain the same elements in the same order.*/

    public static void main(String[] args) {
        LC_2352 obj = new LC_2352();
        int[][] grid = {
            {3,2,1},
            {1,7,6},
            {2,7,7}
        };
        System.out.println(obj.equalPairs(grid));
    }

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> rowMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
        }

        int count = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> col = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                col.add(grid[i][j]);
            }
            count += rowMap.getOrDefault(col, 0);
        }

        return count;
    }
}
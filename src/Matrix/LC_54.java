package Matrix;

import java.util.ArrayList;
import java.util.List;

public class LC_54 {

    //Spiral Matrix

    /*Given an m x n matrix, return all elements of the matrix in spiral order.*/

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        LC_54 obj = new LC_54();
        obj.printList(obj.spiralOrder(matrix));

    }

    public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();

    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {

        // 1. left → right
        for (int col = left; col <= right; col++) {
            result.add(matrix[top][col]);
        }
        top++;

        // 2. top → bottom
        for (int row = top; row <= bottom; row++) {
            result.add(matrix[row][right]);
        }
        right--;

        // 3. right → left
        if (top <= bottom) {
            for (int col = right; col >= left; col--) {
                result.add(matrix[bottom][col]);
            }
            bottom--;
        }

        // 4. bottom → top
        if (left <= right) {
            for (int row = bottom; row >= top; row--) {
                result.add(matrix[row][left]);
            }
            left++;
        }
    }

    return result;
}


    private void printList(List<Integer> list){
        for (Integer val : list) {
            System.out.println(val);
        }
    }
    
}

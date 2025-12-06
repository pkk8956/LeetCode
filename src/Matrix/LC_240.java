package Matrix;

public class LC_240 {

    //Search a 2D Matrix II

    /*Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
    This matrix has the following properties:
        - Integers in each row are sorted in ascending from left to right.
        - Integers in each column are sorted in ascending from top to bottom.*/

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},
                          {2,5,8,12,19},
                          {3,6,9,16,22},
                          {10,13,14,17,24},
                          {18,21,23,26,30}};
        LC_240 obj = new LC_240();
        System.out.println(obj.searchMatrix(matrix, 5));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}

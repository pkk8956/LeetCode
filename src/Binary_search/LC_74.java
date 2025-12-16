package Binary_Search;

public class LC_74 {

    //Search a 2D Matrix

    /*You are given an m x n integer matrix matrix with the following two properties:
     - Each row is sorted in non-decreasing order.
     - The first integer of each row is greater than the last integer of the previous row.
    Given an integer target, return true if target is in matrix or false otherwise.
    You must write a solution in O(log(m * n)) time complexity.*/

    public static void main(String[] args) {
        LC_74 obj = new LC_74();
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};      
        System.out.println(obj.searchMatrix(matrix, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = n * m - 1;

        while (left <= right) {

            int mid = left + ((right - left) >>> 1);
            int midValue = matrix[mid / m][mid % m];
            
            if(midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

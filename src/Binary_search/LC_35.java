package Binary_Search;

public class LC_35 {

    //Search Insert Position

    /*Given a sorted array of distinct integers and a target value, return the index if the target is found.\
    If not, return the index where it would be if it were inserted in order.
    You must write an algorithm with O(log n) runtime complexity.*/

    public static void main(String[] args) {
        LC_35 obj = new LC_35();
        int[] nums = {1,3,5,6};      
        System.out.println(obj.searchInsert(nums, 5));
    }

    public int searchInsert(int[] nums, int target) {

       int left = 0;
       int right = nums.length;

        while (left < right) {

            int mid = left + ((right - left) >>> 1);
            
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;

    }
}

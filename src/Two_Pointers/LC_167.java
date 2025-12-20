package Two_Pointers;

public class LC_167 {

    //Two Sum II - Input Array Is Sorted

    /*Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, 
    find two numbers such that they add up to a specific target number. Let these two numbers be 
    numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
    The tests are generated such that there is exactly one solution. You may not use the same element twice.
    Your solution must use only constant extra space. */

    public static void main(String[] args) {
        LC_167 obj = new LC_167();
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] result = obj.twoSum(numbers, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }

    public int[] twoSum(int[] numbers, int target) {
        //Two Pointers Approach
        int left = 0;
        int right = numbers.length - 1;
        //Since the array is sorted, we can use two pointers to find the target sum
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            //Check if the sum is equal to the target
            if (sum == target) return new int[]{left + 1, right + 1};
            //If the sum is less than the target, move the left pointer to the right
            else if (sum < target) left++;
            //If the sum is greater than the target, move the right pointer to the left
            else right--;
        }
        return new int[]{-1, -1};
    }
}
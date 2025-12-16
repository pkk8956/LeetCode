package Sorting;

public class CyclicSort {

    public static void main(String[] args) {
        CyclicSort cs = new CyclicSort();
        int[] nums = {3, 5, 2, 1, 4};
        cs.cyclicSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    
    // Cyclic Sort Algorithm
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    
    public void cyclicSort(int[] nums) {
    int i = 0;
    while (i < nums.length) {
        int correct = nums[i] - 1; 
        if (nums[i] != nums[correct]) {
            int temp = nums[i];
            nums[i] = nums[correct];
            nums[correct] = temp;
        } else {
            i++;
        }
    }
}

}

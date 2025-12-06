package Two_Pointers;

public class LC_11 {

    //Container With Most Water

    /*You are given an integer array height of length n. There are n vertical lines drawn such that the two 
    endpoints of the ith line are (i, 0) and (i, height[i]). Find two lines that together with the x-axis 
    form a container, such that the container contains the most water. Return the maximum amount of water 
    a container can store.*/

    public static void main(String[] args) {
        LC_11 obj = new LC_11();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(obj.maxArea(height));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
    
}

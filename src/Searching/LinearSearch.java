package Searching;

public class LinearSearch {

    //Linear Search Algorithm

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {  
            if (arr[i] == target) return i;
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] numbers = {3, 5, 1, 9, 7};
        int target = 9;
        int index = linearSearch(numbers, target);
        if (index != -1) {
            System.out.println("Element index is " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}

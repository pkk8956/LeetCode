package Randomised_Algorithms;

public class Run {

    public static void main(String[] args) {
        int[] arr = {34, 7, 23, 32, 5, 62};
        System.out.println("Original array:");
        printArray(arr);

        RandomizedQuickSort.sort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    

    
}

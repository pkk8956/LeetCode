package Sorting;

public class BucketSort {

    /*Bucket Sort is a distribution-based sorting algorithm that works by dividing the input array into several "buckets" and then sorting each bucket individually before combining them back together.
        1. Create an array of empty buckets.
        2. Distribute the elements of the input array into the buckets based on a certain criterion (e.g., range of values).
        3. Sort each bucket individually using a suitable sorting algorithm (e.g., Insertion Sort, Quick Sort).
        4. Concatenate the sorted buckets to form the final sorted array.
    Time Complexity: O(n + k) where n is the number of elements and k is the number of buckets*/

    public static void sort(int[] arr, int bucketCount) {
        if (arr.length == 0) return;

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) minValue = value;
            if (value > maxValue) maxValue = value;
        }

        int bucketRange = (maxValue - minValue) / bucketCount + 1;
        int[][] buckets = new int[bucketCount][];
        int[] bucketSizes = new int[bucketCount];

        for (int value : arr) {
            int bucketIndex = (value - minValue) / bucketRange;
            if (buckets[bucketIndex] == null) {
                buckets[bucketIndex] = new int[arr.length];
            }
            buckets[bucketIndex][bucketSizes[bucketIndex]++] = value;
        }

        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            if (buckets[i] != null) {
                insertionSort(buckets[i], bucketSizes[i]);
                for (int j = 0; j < bucketSizes[i]; j++) {
                    arr[index++] = buckets[i][j];
                }
            }
        }
    }

    private static void insertionSort(int[] arr, int size) {
        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] a = {42, 12, 85, 32, 15, 7, 98, 23};
        BucketSort.sort(a, 5);
        for (int x : a) System.out.print(x + " ");
    }
}
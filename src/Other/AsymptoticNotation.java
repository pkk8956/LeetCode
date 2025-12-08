/*
    ============================
          Asymptotic Notation
    ============================

    Big O — O(f(n)):
        Upper bound on the growth of time or space.
        Describes the worst-case scenario.
        Example: Binary search — O(log n).

    Big Theta — Θ(f(n)):
        Tight bound.
        Means the algorithm grows exactly as f(n) asymptotically.
        f(n) is both O(g(n)) and Ω(g(n)).
        Example: Summing an array — Θ(n).

    Big Omega — Ω(f(n)):
        Lower bound.
        Minimum time the algorithm will definitely take.
        Example: Reading n elements — Ω(n).

    Small o — o(f(n)):
        Strictly smaller growth than f(n) as n → ∞.
        Not a tight bound.
        Example: n is o(n log n).

    Small omega — ω(f(n)):
        Strictly larger growth than f(n) as n → ∞.
        Not a tight bound.
        Example: n log n is ω(n).

    Growth hierarchy:
        O(1) < O(log n) < O(n) < O(n log n) < O(n^2) < O(2^n) < O(n!)
*/


package Other;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class AsymptoticNotation {

    // O(1)
    // Typical examples:
    // - Accessing array element by index
    // - Checking collection size
    public static int constant(int[] a) {
        return a.length > 0 ? a[0] : -1;
    }

    // O(log n)
    // Typical examples:
    // - Binary search
    // - Operations in balanced BST structures (TreeSet, TreeMap)
    public static int logN_binarySearch(int[] sorted, int target) {
        int l = 0, r = sorted.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (sorted[m] == target) return m;
            if (sorted[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    // O(n)
    // Typical examples:
    // - Linear search
    // - One full traversal through an array or list
    public static long linearSum(int[] a) {
        long sum = 0;
        for (int v : a) sum += v;
        return sum;
    }

    // O(n log n)
    // Typical examples:
    // - Merge sort
    // - Quick sort (average case)
    // - Arrays.sort() for primitives
    public static void nLogN_sort(int[] a) {
        Arrays.sort(a);
    }

    // O(n^2)
    // Typical examples:
    // - Bubble sort
    // - Nested loops over all pairs
    public static long quadraticCountPairs(int[] a) {
        long count = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] > 0) count++;
            }
        }
        return count;
    }

    // O(n^3)
    // Typical examples:
    // - Triple nested loops
    // - Some naive 3D DP algorithms
    public static long cubicTriples(int[] a) {
        long count = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if ((long)a[i] + a[j] + a[k] > 0) count++;
                }
            }
        }
        return count;
    }

    // O(2^n)
    // Typical examples:
    // - Naive recursive Fibonacci
    // - Generating all subsets
    public static int exponentialFib(int n) {
        if (n <= 1) return n;
        return exponentialFib(n - 1) + exponentialFib(n - 2);
    }

    // O(n!)
    // Typical examples:
    // - Generating all permutations
    // - Brute-force Traveling Salesman
    public static List<List<Integer>> factorialPermutations(List<Integer> items) {
        List<List<Integer>> res = new ArrayList<>();
        permute(items, 0, res);
        return res;
    }

    private static void permute(List<Integer> arr, int i, List<List<Integer>> out) {
        if (i >= arr.size()) {
            out.add(new ArrayList<>(arr));
            return;
        }
        for (int j = i; j < arr.size(); j++) {
            swap(arr, i, j);
            permute(arr, i + 1, out);
            swap(arr, i, j);
        }
    }

    private static void swap(List<Integer> arr, int i, int j) {
        int t = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, t);
    }

    public static void main(String[] args) {
        int[] a = {3, -1, 4, 1, 5};
        System.out.println("O(1) constant: " + constant(a));

        int[] sorted = a.clone();
        Arrays.sort(sorted);
        System.out.println("O(log n) binarySearch(4): " + logN_binarySearch(sorted, 4));

        System.out.println("O(n) linearSum: " + linearSum(a));

        int[] toSort = {5,2,9,1,6};
        nLogN_sort(toSort);
        System.out.println("O(n log n) sorted: " + Arrays.toString(toSort));

        System.out.println("O(n^2) quadraticCountPairs: " + quadraticCountPairs(a));

        System.out.println("O(n^3) cubicTriples: " + cubicTriples(a));

        System.out.println("O(2^n) exponentialFib(10): " + exponentialFib(10));

        List<Integer> items = Arrays.asList(1,2,3);
        List<List<Integer>> perms = factorialPermutations(new ArrayList<>(items));
        System.out.println("O(n!) permutations of [1,2,3]: " + perms);
    }
}

package Binary_Search;

public class LC_2300 {

    // Successful Pairs of Spells and Potions

    /* You are given two arrays of integers: spells and potions. Each element in spells represents the strength of a spell,
       and each element in potions represents the strength of a potion. You are also given an integer success.
       A spell and potion pair is considered successful if the product of their strengths is at least success.
       Your task is to determine, for each spell, how many potions can form a successful pair with it.
       Return an array of integers where the i-th element is the number of potions that can form a successful pair with the i-th spell.
    */

    public static void main(String[] args) {
        LC_2300 obj = new LC_2300();
        int[] spells = {5,1,3,4};
        int[] potions = {2,4,1,2};
        long success = 4;
        System.out.println(obj.successfulPairs(spells, potions, success));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int[] result = new int[n];
        java.util.Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int left = 0, right = m - 1;
            int spell = spells[i];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long product = (long) spell * potions[mid];
                if (product >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = m - left;
        }
        return result;
    }
    
}

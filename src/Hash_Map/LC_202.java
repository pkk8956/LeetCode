package Hash_Map;

public class LC_202 {

    // Happy Number

    /* A happy number is a number defined by the following process: Starting with any 
    positive integer, replace the number by the sum of the squares of its digits,
    and repeat the process until the number equals 1 (where it will stay), 
    or it loops endlessly in a cycle that does not include 1.
    Those numbers for which this process ends in 1 are happy. 
    Return true if n is a happy number, and false otherwise. */

    public static void main(String[] args) {
        LC_202 obj = new LC_202();
        int n = 19;
        System.out.println(obj.isHappy(n));
    }

    public boolean isHappy(int n) {
        //Using Floyd's Cycle Detection Algorithm
        int slow = n;
        int fast = n;

        do {
            slow = getNext(slow); // Move slow by one step
            fast = getNext(getNext(fast)); // Move fast by two steps
        } while (slow != fast);

        return slow == 1; // If they meet at 1, then it's a happy number
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }
    
}

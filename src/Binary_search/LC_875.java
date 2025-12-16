package Binary_Search;

public class LC_875 {

    // Koko Eating Bananas

    /*Koko loves to eat bananas. There are n piles of bananas, the i-th pile has piles[i] bananas. 
    The guards have gone and will come back in h hours.
    Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of 
    bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all 
    of them instead and will not eat any more bananas during that hour.
    Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
    Return the minimum integer k such that she can eat all the bananas within h hours.*/

    public static void main(String[] args) {
        LC_875 obj = new LC_875();
        int[] piles = {3,6,7,11};
        int h = 8;
        int result = obj.minEatingSpeed(piles, h);
        System.out.println(result);  
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Integer.MIN_VALUE;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += (pile + speed - 1) / speed;
        }
        return hoursNeeded <= h;
    }
    
}

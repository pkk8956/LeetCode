package Binary_Search;

public class LC_374 {

    // Guess Number Higher or Lower

    /* We are playing the Guess Game. The game is as follows:
    I pick a number from 1 to n. You have to guess which number I picked.
    Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
    You call a pre-defined API int guess(int num), which returns three possible results:
    -1: Your guess is higher than the number I picked (i.e. num > pick).
    1: Your guess is lower than the number I picked (i.e. num < pick).
    0: Your guess is equal to the number I picked (i.e. num == pick).
    Return the number that I picked.*/

    public static void main(String[] args) {
        LC_374 obj = new LC_374();
        int n = 10;
        System.out.println(obj.guessNumber(n));
    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = guess(mid);
            if (result == 0) {
                return mid;
            } else if (result == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int guess(int num) {
        return 0; // Placeholder for the actual guess API implementation
    }
}
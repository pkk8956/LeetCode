package Arrays_and_Strings;

public class LC_605 {

    //Can Place Flowers

    /*You have a long flowerbed in which some of the plots are planted, and some are not. However, 
    flowers cannot be planted in adjacent plots. Given an integer array flowerbed containing 0's and 1's, 
    where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted 
    in the flowerbed without violating the no-adjacent-flowers rule.*/

    public static void main(String[] args) {
        LC_605 obj = new LC_605();
        int[] flowerbed = {1,0,0,0,1};
        int n = 1;
        System.out.println(obj.canPlaceFlowers(flowerbed, n));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeft = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRight = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                if (emptyLeft && emptyRight) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}

package Arrays_and_Strings;

import java.util.ArrayList;
import java.util.List;

public class LC_1431 {

    //Kids With the Greatest Number of Candiesq

    /*Given the array candies and the integer extraCandies, where candies[i] represents 
    the number of candies that the ith kid has. For each kid check if there is a way to 
    distribute extraCandies among the kids such that he or she can have the greatest number 
    of candies among them. Notice that multiple kids can have the greatest number of candies.*/

    public static void main(String[] args) {
        LC_1431 obj = new LC_1431();
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(obj.kidsWithCandies(candies, extraCandies));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = Integer.MIN_VALUE;
        for (int candy : candies) maxCandies = Math.max(maxCandies, candy);
        for (int candy : candies) {
            if (candy + extraCandies >= maxCandies) result.add(true);
            else result.add(false);
        }
        return result;
    }
}

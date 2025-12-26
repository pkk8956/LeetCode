package Arrays_and_Strings;

public class LC_1732 {

    // Find the Highest Altitude

    /*There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. 
    The biker starts his trip on point 0 with altitude equal 0.
    You are given an integer array gain of length n where gain[i] is the net gain in altitude between 
    points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.*/

    public static void main(String[] args) {
        LC_1732 obj = new LC_1732();
        int[] gain = {-5,1,5,0,-7};
        System.out.println(obj.largestAltitude(gain));
    }

    public int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int currentAltitude = 0;
        for (int g : gain) {
            currentAltitude += g;
            highestAltitude = Math.max(highestAltitude, currentAltitude);
        }
        return highestAltitude;
    }
}

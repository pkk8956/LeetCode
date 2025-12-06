package Misc;

public class LC_1342 {

    //Number of Steps to Reduce a Number to Zero

    /*Given an integer num, return the number of steps to reduce it to zero.
    In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it. */

    public static void main(String[] args) {
        LC_1342 obj = new LC_1342();      
        System.out.println(obj.numberOfSteps(14));
    }

    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = (num % 2 == 0) ? num / 2 : --num;      
        }

        //String binary = Integer.toBinaryString(num);
        //return binary.replace("0", "").length() * 2 + binary.replace("1", "").length() - 1;

        return count; 
    }
}

package Dynamic_Programming;

public class LC_70 {

    //Climbing Stairs

    /*You are climbing a staircase. It takes n steps to reach the top. 
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/

    public static void main(String[] args) {
        LC_70 obj = new LC_70();  
            
        System.out.println(obj.climbStairs(3));
    }

    public int climbStairs(int n) {
       if (n <= 1) return 1;

        int a = 1; 
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}

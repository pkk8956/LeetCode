package Stack;

public class LC_735 {

    //Asteroid Collision

    /*We are given an array asteroids of integers representing asteroids in a row.
    For each asteroid, the absolute value represents its size, and the sign represents 
    its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
    Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
    If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.*/

    public static void main(String[] args) {
        LC_735 obj = new LC_735();
        int[] asteroids = {5, 10, -5};
        int[] result = obj.asteroidCollision(asteroids);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }

    public int[] asteroidCollision(int[] asteroids) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop();
                } else if (stack.peek() == -asteroid) {
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
    
}

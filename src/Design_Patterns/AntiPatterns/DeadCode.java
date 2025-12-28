package Design_Patterns.AntiPatterns;

public class DeadCode {
    public static void main(String[] args) {
        System.out.println("Program started.");

        // Active code
        int x = 10;
        if (x > 5) {
            System.out.println("x is greater than 5");
        } else {
            // Dead code: this block can never be reached
            System.out.println("x is less than or equal to 5");
        }

        // Dead code: method that is never called
        // Keeping it here but it's never used
        /*
        public static void unusedMethod() {
            System.out.println("This method is never called");
        }
        */

        // Dead code: variable that is never used
        // int unusedVariable = 42;

        System.out.println("Program finished.");
    }
}

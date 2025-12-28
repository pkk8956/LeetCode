package Design_Patterns.AntiPatterns;

import java.util.Scanner;

public class SpaghettiCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        System.out.println("Enter your age:");
        int age = 0;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age input!");
        }

        if (age < 18) {
            System.out.println("You are too young.");
        } else if (age < 30) {
            System.out.println("You are young!");
        } else if (age < 50) {
            System.out.println("You are in middle age.");
        } else {
            System.out.println("You are wise!");
        }

        System.out.println("Do you want to calculate the factorial of a number? (yes/no)");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Enter a number:");
            int num = 0;
            try {
                num = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number input!");
            }

            int factorial = 1;
            for (int i = 1; i <= num; i++) {
                factorial *= i;
            }

            System.out.println("Factorial of " + num + " = " + factorial);
        }

        System.out.println("Do you want to check if a number is even or odd? (yes/no)");
        answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Enter a number:");
            int num = 0;
            try {
                num = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number input!");
            }

            if (num % 2 == 0) {
                System.out.println("Number " + num + " is even");
            } else {
                System.out.println("Number " + num + " is odd");
            }
        }

        System.out.println("Thank you, " + name + ", for using the program!");
        scanner.close();
    }
}


package Other;

import java.math.BigInteger;

public class Combinatorics {

    public static void main(String[] args) {
        factorialExample();
        permutationsExample();
        arrangementsExample();
        combinationsExample();
        combinationsWithRepetitionExample();
    }

    // 1. Factorial: n!
    static void factorialExample() {
        int n = 5;
        BigInteger result = factorial(n);

        System.out.println("Factorial " + n + "! = " + result);
    }

    static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    // 2. Permutations: n!
    // Order matters, all elements are used
    static void permutationsExample() {
        int n = 5;
        BigInteger permutations = factorial(n);

        System.out.println("Permutations of " + n + " elements = " + permutations);
    }

    // 3. Arrangements (variations): n! / (n - k)!
    // Order matters, choose k elements
    static void arrangementsExample() {
        int n = 5;
        int k = 3;

        BigInteger arrangements =
                factorial(n).divide(factorial(n - k));

        System.out.println("Arrangements A(" + n + ", " + k + ") = " + arrangements);
    }

    // 4. Combinations: n! / (k! * (n - k)!)
    // Order does NOT matter
    static void combinationsExample() {
        int n = 5;
        int k = 3;

        BigInteger combinations =
                factorial(n).divide(
                        factorial(k).multiply(factorial(n - k))
                );

        System.out.println("Combinations C(" + n + ", " + k + ") = " + combinations);
    }

    // 5. Combinations with repetition
    // C(n + k - 1, k)
    static void combinationsWithRepetitionExample() {
        int n = 3;
        int k = 5;

        BigInteger result =
                factorial(n + k - 1).divide(
                        factorial(k).multiply(factorial(n - 1))
                );

        System.out.println("Combinations with repetition = " + result);
    }
}

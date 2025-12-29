package Other;

import java.util.*;

public class Probability {

    static Random random = new Random();

    public static void main(String[] args) {
        bernoulliTrial();
        binomialDistribution();
        conditionalProbability();
        expectedValue();
        varianceExample();
        lawOfLargeNumbers();
    }

    // 1. Bernoulli trial
    // A random experiment with two outcomes: success / failure
    static void bernoulliTrial() {
        double p = 0.3;

        boolean success = random.nextDouble() < p;

        System.out.println("Bernoulli trial (p = " + p + "): success = " + success);
    }

    // 2. Binomial distribution
    // Number of successes in N independent Bernoulli trials
    static void binomialDistribution() {
        int n = 10;
        double p = 0.3;
        int successes = 0;

        for (int i = 0; i < n; i++) {
            if (random.nextDouble() < p) {
                successes++;
            }
        }

        System.out.println("Binomial distribution:");
        System.out.println("Trials = " + n + ", p = " + p + ", successes = " + successes);
    }

    // 3. Conditional probability
    // P(A | B) = P(A ∩ B) / P(B)
    static void conditionalProbability() {
        int total = 1_000_000;
        int eventB = 0;
        int eventAandB = 0;

        for (int i = 0; i < total; i++) {
            boolean A = random.nextDouble() < 0.4;
            boolean B = random.nextDouble() < 0.5;

            if (B) eventB++;
            if (A && B) eventAandB++;
        }

        double pA_given_B = (double) eventAandB / eventB;

        System.out.println("Conditional probability P(A | B) ≈ " + pA_given_B);
    }

    // 4. Expected value (mathematical expectation)
    static void expectedValue() {
        double[] values = {0, 50, 100};
        double[] probabilities = {0.7, 0.2, 0.1};

        double expectation = 0;

        for (int i = 0; i < values.length; i++) {
            expectation += values[i] * probabilities[i];
        }

        System.out.println("Expected value E[X] = " + expectation);
    }

    // 5. Variance and standard deviation
    static void varianceExample() {
        double[] values = {0, 50, 100};
        double[] probabilities = {0.7, 0.2, 0.1};

        double mean = 0;
        for (int i = 0; i < values.length; i++) {
            mean += values[i] * probabilities[i];
        }

        double variance = 0;
        for (int i = 0; i < values.length; i++) {
            variance += Math.pow(values[i] - mean, 2) * probabilities[i];
        }

        double stdDeviation = Math.sqrt(variance);

        System.out.println("Variance = " + variance);
        System.out.println("Standard deviation = " + stdDeviation);
    }

    // 6. Law of Large Numbers
    static void lawOfLargeNumbers() {
        double p = 0.3;
        int trials = 1_000_000;
        int success = 0;

        for (int i = 1; i <= trials; i++) {
            if (random.nextDouble() < p) {
                success++;
            }
        }

        double frequency = (double) success / trials;

        System.out.println("Law of Large Numbers:");
        System.out.println("Theoretical probability = " + p);
        System.out.println("Empirical frequency     = " + frequency);
    }
}

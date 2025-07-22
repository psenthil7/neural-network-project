/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

public class Exerc03_E {

    /**
     * Calculate the nth Fibonacci number using dynamic programming.
     * 
     * @param n The index of the Fibonacci number.
     * @return The nth Fibonacci number.
     */
    private static long fibFaster(int n) {
        long[] dp = new long[Math.max(2, n + 1)];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void runFibFasterMany() {
        for (int i = 0; i <= 50; ++i) {
            long startTime = System.nanoTime();
            long val = fibFaster(i);
            long endTime = System.nanoTime();
            System.out.printf("fib(%d) = %d \t time: %fs\n", i, val, (endTime - startTime) / 1e9);
        }
    }

    public static void main(String[] args) {
        runFibFasterMany();
    }

}

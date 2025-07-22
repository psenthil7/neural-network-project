/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

public class Exerc03_D_1 {

    /**
     * Calculate the nth Fibonacci number using memoization.
     * 
     * @param n   The index of the Fibonacci number.
     * @param mem The memoization array with n + 1 elements initially with all nulls.
     * @return The nth Fibonacci number.
     */
    private static long fibFast(int n, Long[] mem) {
        if (mem[n] != null) {
            return mem[n];
        }

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // Recursive case.
        long prev = fibFast(n - 1, mem);
        long prevPrev = fibFast(n - 2, mem);
        long ans = prev + prevPrev;

        mem[n] = ans;

        return ans;
    }

    public static void runFibFastMany() {
        for (int i = 0; i <= 50; ++i) {
            long startTime = System.nanoTime();
            long val = fibFast(i, new Long[i + 1]);
            long endTime = System.nanoTime();
            System.out.printf("fib(%d) = %d \t time: %fs\n", i, val, (endTime - startTime) / 1e9);
        }
    }

    public static void main(String[] args) {
        runFibFastMany();
    }

}

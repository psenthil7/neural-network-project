/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

public class Exerc03_F {

    /**
     * Calculate the nth Fibonacci number using dynamic programming with constant
     * space.
     * 
     * @param n The index of the Fibonacci number.
     * @return The nth Fibonacci number.
     */
    private static long fibEvenBetter(int n) {
        if (n == 0) {
            return 0;
        }
        long a = 0;
        long b = 1;
        for (int i = 2; i <= n; ++i) {
            long tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }

    public static void runFibFasterMany() {
        for (int i = 0; i <= 50; ++i) {
            long startTime = System.nanoTime();
            long val = fibEvenBetter(i);
            long endTime = System.nanoTime();
            System.out.printf("fib(%d) = %d \t time: %fs\n", i, val, (endTime - startTime) / 1e9);
        }
    }

    public static void main(String[] args) {
        runFibFasterMany();
    }

}

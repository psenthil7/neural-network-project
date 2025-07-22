/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

public class Exerc03_C_2 {

    /**
     * Calculate the nth Fibonacci number.
     * 
     * @param n The index of the Fibonacci number.
     * @return The nth Fibonacci number.
     */
    static int fCount = 0;
    static int timeStep = 0;
    private static long fibTraceable(int n) {
        ++fCount; // Stack frame count.

        // Stack frame visualization.
        System.out.printf("t%03d |", ++timeStep);
        System.out.println("_____|".repeat(fCount) + "s:fib(" + n + "): ?");

        // First base case.
        if (n == 0) {
            // Stack frame visualization.
            System.out.printf("t%03d |", ++timeStep);
            System.out.println("_____|".repeat(fCount) + "e:fib(" + n + "): 0");
            --fCount; // Stack frame count.

            return 0;
        }

        // Second base case.
        if (n == 1) {
            // Stack frame visualization.
            System.out.printf("t%03d |", ++timeStep);
            System.out.println("_____|".repeat(fCount) + "e:fib(" + n + "): 1");
            --fCount; // Stack frame count.
            
            return 1;
        }

        // Recursive case.
        long prev = fibTraceable(n - 1);
        long prevPrev = fibTraceable(n - 2);
        long ans = prev + prevPrev;

        // Stack frame visualization.
        System.out.printf("t%03d |", ++timeStep);
        System.out.println("_____|".repeat(fCount) + "e:fib(" + n + "): " + ans);
        --fCount; // Stack frame count.

        return ans;
    }

    public static void main(String[] args) {
        long val = fibTraceable(5);
        System.out.println("\n\nfib(5) = " + val);
    }

}

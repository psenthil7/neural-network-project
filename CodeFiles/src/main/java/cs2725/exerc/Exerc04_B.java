/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

public class Exerc04_B {

    /**
     * This is a constant time function. It runs in O(1) time.
     */
    private static void constantTimeFunction(int n) {
        int reps = 10;
        long sum = 0;
        for (int i = 0; i < reps; ++i) {
            sum += 1;
        }
        System.out.println("Output: " + sum);
    }

    /**
     * This is a logn time function. It runs in O(logn) time.
     */
    private static void lognTimeFunction(int n) {
        long sum = 0;
        for (int i = n; i > 0; i /= 2) {
            sum += 1;
        }
        System.out.println("Output: " + sum);
    }

    /**
     * This is a linear time function. It runs in O(n) time.
     */
    private static void linearTimeFunction(int n) {
        long sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += 1;
        }
        System.out.println("Output: " + sum);
    }

    /**
     * This is a nlogn time function. It runs in O(nlogn) time.
     */
    private static void nlognTimeFunction(int n) {
        long sum = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = n; j > 0; j /= 2) {
                sum += 1;
            }
        }
        System.out.println("Output: " + sum);
    }

    /**
     * This is a quadratic time function. It runs in O(n^2) time.
     */
    private static void quadraticTimeFunction(int n) {
        long sum = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                sum += 1;
            }
        }
        System.out.println("Output: " + sum);
    }

    /**
     * This is a cubic time function. It runs in O(n^3) time.
     */
    private static void cubicTimeFunction(int n) {
        long sum = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    sum += 1;
                }
            }
        }
        System.out.println("Output: " + sum);
    }

    /**
     * This is an exponential time function. It runs in O(2^n) time.
     */
    private static int exponentialTimeFunction(int n) {
        if (n == 0) {
            return 1;
        }
        return exponentialTimeFunction(n - 1) + exponentialTimeFunction(n - 1);
    }

    public static void main(String[] args) {
        // We will run each function with n = 10. And time each one of them.
        int n = 1000000;

        // Declare the start and end time variables.
        long startTime = 0, endTime = 0;

        startTime = System.nanoTime();
        constantTimeFunction(n);
        endTime = System.nanoTime();
        System.out.println("Time taken by constantTimeFunction: " + (endTime - startTime) / 1e9 + " s");

        System.out.println("=====================================");

        startTime = System.nanoTime();
        lognTimeFunction(n);
        endTime = System.nanoTime();
        System.out.println("Time taken by lognTimeFunction: " + (endTime - startTime) / 1e9 + " s");

        System.out.println("=====================================");

        startTime = System.nanoTime();
        linearTimeFunction(n);
        endTime = System.nanoTime();
        System.out.println("Time taken by linearTimeFunction: " + (endTime - startTime) / 1e9 + " s");

        System.out.println("=====================================");

        startTime = System.nanoTime();
        nlognTimeFunction(n);
        endTime = System.nanoTime();
        System.out.println("Time taken by nlognTimeFunction: " + (endTime - startTime) / 1e9 + " s");

        System.out.println("=====================================");

        startTime = System.nanoTime();
        quadraticTimeFunction(n);
        endTime = System.nanoTime();
        System.out.println("Time taken by quadraticTimeFunction: " + (endTime - startTime) / 1e9 + " s");

        System.out.println("=====================================");

        startTime = System.nanoTime();
        cubicTimeFunction(n);
        endTime = System.nanoTime();
        System.out.println("Time taken by cubicTimeFunction: " + (endTime - startTime) / 1e9 + " s");

        System.out.println("=====================================");

        startTime = System.nanoTime();
        exponentialTimeFunction(n);
        endTime = System.nanoTime();
        System.out.println("Time taken by exponentialTimeFunction: " + (endTime - startTime) / 1e9 + " s");

        System.out.println("=====================================");
    }

}

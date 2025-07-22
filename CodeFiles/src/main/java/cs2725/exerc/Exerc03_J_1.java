/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

public class Exerc03_J_1 {

    /**
     * Calculate the number of ways to make change for a given amount using the
     * given coins. This method uses memoization.
     * 
     * @param amount     The amount to make change for.
     * @param coins      The coins available. No zero coins. No duplicates.
     * @param startIndex The index of the first coin to consider.
     * @return The number of ways to make change.
     */
    private static int changeWays(int amount, int[] coins, int startIndex, Integer[][] mem) {
        if (amount == 0) {
            return 1;
        }

        if (startIndex == coins.length || amount < 0) {
            return 0;
        }

        if (mem[amount][startIndex] != null) {
            return mem[amount][startIndex];
        }

        int waysWithStart = changeWays(amount - coins[startIndex], coins, startIndex, mem);
        int waysWithoutStart = changeWays(amount, coins, startIndex + 1, mem);
        int waysTotal = waysWithStart + waysWithoutStart;

        mem[amount][startIndex] = waysTotal;

        return waysTotal;
    }

    public static void main(String[] args) {
        int amount = 100000;
        int[] coins = { 1, 2, 3 };
        Integer[][] mem = new Integer[amount + 1][coins.length];
        int ways = changeWays(amount, coins, 0, mem);
        System.out.println(ways);
    }

}

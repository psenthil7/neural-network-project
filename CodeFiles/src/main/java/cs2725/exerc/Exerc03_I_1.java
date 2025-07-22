/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

import java.util.Arrays;

public class Exerc03_I_1 {

    /**
     * Calculate the number of ways to make change for a given amount using the
     * given coins.
     * 
     * @param amount         The amount to make change for.
     * @param coins          The coins available. No zero coins. No duplicates.
     * @param coinStartIndex The index of the first coin to consider.
     * @return The number of ways to make change.
     */
    private static int changeWays(int amount, int[] coins, int coinStartIndex) {
        if (amount == 0) {
            return 1;
        }

        if (coinStartIndex == coins.length || amount < 0) {
            return 0;
        }

        int waysWithStart = changeWays(amount - coins[coinStartIndex], coins, coinStartIndex);
        int waysWithoutStart = changeWays(amount, coins, coinStartIndex + 1);
        int waysTotal = waysWithStart + waysWithoutStart;

        return waysTotal;
    }

    public static void main(String[] args) {
        int amount = 3;
        int[] coins = { 1, 2, 3 };
        int ways = changeWays(amount, coins, 0);
        System.out.printf("Number of ways to make change for %d using %s: %d\n", amount, Arrays.toString(coins), ways);
    }

}

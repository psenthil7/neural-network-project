/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

import java.util.Arrays;

import cs2725.api.List;
import cs2725.impl.ArrayList;

public class Exerc03_L {

    /**
     * Calculate the number of ways to make change for a given amount using the
     * given coins. The function also prints the valid combinations.
     * 
     * @param amount         The amount to make change for.
     * @param coins          The coins available. No zero coins. No duplicates.
     * @param coinStartIndex The index of the first coin to consider.
     * @param combination    The current combination of coins.
     * @return The number of ways to make change.
     */
    private static int changeWays(int amount, int[] coins, int coinStartIndex, List<Integer> combination) {
        if (amount == 0) {
            // Print the current valid combination at a leaf node.
            System.out.println(combination);
            return 1;
        }

        if (coinStartIndex == coins.length || amount < 0) {
            return 0;
        }

        // Include the coin at the current index.
        combination.insertItem(coins[coinStartIndex]);

        int waysWithStart = changeWays(amount - coins[coinStartIndex], coins, coinStartIndex, combination);

        // Remove the coin at the current index.
        combination.deleteItemAt(combination.size() - 1);

        int waysWithoutStart = changeWays(amount, coins, coinStartIndex + 1, combination);
        int waysTotal = waysWithStart + waysWithoutStart;

        return waysTotal;
    }

    public static void main(String[] args) {
        int amount = 3;
        int[] coins = { 1, 2, 3 };
        int ways = changeWays(amount, coins, 0, new ArrayList<>());
        System.out.printf("Number of ways to make change for %d using %s: %d\n", amount, Arrays.toString(coins), ways);
    }

}

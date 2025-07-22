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
import cs2725.util.Util;

public class Exerc03_I_2 {

    /**
     * Calculate the number of ways to make change for a given amount using the
     * given coins. This method is traceable.
     * 
     * @param amount         The amount to make change for.
     * @param coins          The coins available. No zero coins. No duplicates.
     * @param coinStartIndex The index of the first coin to consider.
     * @return The number of ways to make change.
     */
    static int fCount = 0;
    static int timeStep = 0;
    static List<List<Integer>> combinations;

    private static int changeWays(int amount, int[] coins, int coinStartIndex, List<Integer> combination) {
        ++fCount; // Stack frame count.

        // Stack frame visualization.
        System.out.printf("t%03d |", ++timeStep);
        System.out.println("_____|".repeat(fCount)
                + String.format("ccw(%d, %s, %d): ?", amount, Arrays.toString(coins), coinStartIndex));

        if (amount == 0) {
            // Stack frame visualization.
            System.out.printf("t%03d |", ++timeStep);
            System.out.println(
                    "_____|".repeat(fCount)
                            + String.format("ccw(%d, %s, %d): %d", amount, Arrays.toString(coins), coinStartIndex, 1));
            --fCount; // Stack frame count.

            combinations.insertItem(Util.copyList(combination)); // Add the combination to the list of combinations.

            return 1;
        }

        if (coinStartIndex == coins.length || amount < 0) {
            // Stack frame visualization.
            System.out.printf("t%03d |", ++timeStep);
            System.out.println(
                    "_____|".repeat(fCount)
                            + String.format("ccw(%d, %s, %d): %d", amount, Arrays.toString(coins), coinStartIndex, 0));
            --fCount; // Stack frame count.

            combinations.insertItem(Util.copyList(combination)); // Add the combination to the list of combinations.

            return 0;
        }

        combination.insertItem(coins[coinStartIndex]); // Add the selected coin to the combination.

        int waysWithStart = changeWays(amount - coins[coinStartIndex], coins, coinStartIndex, combination);

        combination.deleteItemAt(combination.size() - 1); // Remove the selected coin from the combination.

        int waysWithoutStart = changeWays(amount, coins, coinStartIndex + 1, combination);
        int waysTotal = waysWithStart + waysWithoutStart;

        // Stack frame visualization.
        System.out.printf("t%03d |", ++timeStep);
        System.out.println(
                "_____|".repeat(fCount) + String.format("ccw(%d, %s, %d): %d", amount, Arrays.toString(coins),
                        coinStartIndex, waysTotal));
        --fCount; // Stack frame count.

        return waysTotal;
    }

    public static void main(String[] args) {
        combinations = new ArrayList<>();

        int amount = 4;
        int[] coins = { 1, 2 };

        int ways = changeWays(amount, coins, 0, new ArrayList<>());

        System.out.printf("Number of ways to make change for %d using %s: %d\n", amount, Arrays.toString(coins), ways);

        for (int i = 0; i < combinations.size(); i++) {
            System.out.println(combinations.getItem(i));
        }
    }

}

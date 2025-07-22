/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

public class Exerc03_K {

    /**
     * Calculate the number of ways to make change for a given amount using the
     * given coins. This method uses memoization.
     * 
     * @param amount The amount to make change for.
     * @param coins  The coins available. No zero coins. No duplicates.
     * @return The number of ways to make change.
     */
    private static int changeWays(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];

        for (int i = 0; i <= coins.length; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                dp[i][j] = dp[i][j + 1];
                if (i - coins[j] >= 0) {
                    dp[i][j] += dp[i - coins[j]][j];
                }
            }
        }

        return dp[amount][0];
    }

    public static void main(String[] args) {
        int amount = 4;
        int[] coins = { 1, 2, 3 };

        int ways = changeWays(amount, coins);
        System.out.println("\nNumber of ways to make change: " + ways);
    }

}

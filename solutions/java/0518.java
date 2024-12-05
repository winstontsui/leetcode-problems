/*
 * Leetcode 518: Coin Change II. Java. Medium.
 * O(n * m) runtime and O(n) space complexity, where n is the amount and m is the number of coins.
 * Use dynamic programming with a 1D array, `combinations`,
 * where `combinations[i]` represents the number of ways to make amount `i`.
 * For each coin, update the array by adding combinations for amounts that include the coin.
 * This approach efficiently calculates the total ways to make the target amount.
 * 12/5/2024 Winston Tsui
 */

class Solution {
    public int change(int amount, int[] coins) {
        int[] combinations = new int[amount + 1];
        combinations[0] = 1; // Base case: 1 way to make amount 0

        // Iterate over each coin
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                combinations[i] += combinations[i - coin];

        return combinations[amount];
    }
}

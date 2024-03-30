/*
 * Leetcode 322: Coin Change. Java. Medium.
 * O(coins.length * amount) runtime and O(amount) space complexity. 
 * Dynamic Programming solution. When the amount is 0, no coins can make up that amount.
 * The amount after that depends on the values at numCoins[i-c], where c are coin values.
 * 3/30/2024 Winston Tsui
*/

class Solution {
    int coinChange(int[] coins, int amount) {
        int[] numCoins = new int[amount + 1];
        // I can also do Arrays.fill(numCoins, amount+1);
        for (int i = 0; i < numCoins.length; i++)
            numCoins[i] = amount + 1;

        numCoins[0] = 0;
        for (int i = 1; i <= amount; i++)
            for (int c : coins)
                if (i - c > -1)
                    numCoins[i] = Math.min(numCoins[i], 1 + numCoins[i - c]);

        // Edge case where no coins can add up to amount.
        if (numCoins[amount] > amount)
            return -1;
        return numCoins[amount];
    }
}

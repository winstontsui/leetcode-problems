/*
 * Leetcode 96: Unique Binary Search Trees. Java. Medium.
 * O(n^2) runtime and O(n) space complexity.
 * Dynamic Programming solution. Build a table where dp[i] represents the number of BSTs for i nodes.
 * The key is to multiply the number of possible BSTs for the left and right subtrees excluding the root for every possible root.
 * 7/16/2024 Winston Tsui
*/

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i; j++)
                dp[i] += dp[j - 1] * dp[i - j];
        return dp[n];

    }
}

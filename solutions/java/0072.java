/*
 * Leetcode 72: Edit Distance. Java. Medium.
 * O(m * n) runtime and O(m * n) space complexity, where m and n are the lengths of word1 and word2.
 * Uses dynamic programming to compute the minimum number of operations (insert, delete, replace)
 * required to convert word1 into word2. The DP table is filled from the bottom-right corner,
 * with each cell representing the minimum operations needed for the corresponding substrings.
 * Insights: Backward iteration enables seamless handling of the base cases for empty substrings.
 * 1/5/2025
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] minOperations = new int[len1 + 1][len2 + 1];
        // Fill in bottom row base cases
        for (int j = 0; j < word2.length(); j++)
            minOperations[word1.length()][j] = word2.length() - j;

        // Fill in rightmost row base cases
        for (int i = 0; i < word1.length(); i++)
            minOperations[i][word2.length()] = word1.length() - i;

        for (int r = len1 - 1; r >= 0; r--) {
            for (int c = len2 - 1; c >= 0; c--) {
                if (word1.charAt(r) == word2.charAt(c))
                    minOperations[r][c] = minOperations[r + 1][c + 1];
                else
                    minOperations[r][c] = Math.min(1 + minOperations[r + 1][c],
                            Math.min(1 + minOperations[r + 1][c + 1], 1 + minOperations[r][c + 1]));
            }
        }

        return minOperations[0][0];
    }
}

/*
 * Leetcode 72: Edit Distance. Java. Hard.
 * O(m * n) runtime and O(n) space complexity using optimized 1D dynamic programming.
 * Transforms word1 into word2 with the minimum number of operations: insert, delete, replace.
 * Maintains a current and previous row of the DP table to save space while computing the edit distance.
 * Insights: The table is filled from bottom-right to top-left, iterating over word1 and word2 in reverse.
 * 1/5/2025
 */

 class Solution {
    public int minDistance(String word1, String word2) {
        int[] curr = new int[word2.length() + 1];
        int[] prev = new int[word2.length() + 1];

        // Fill in bottom row base cases
        for (int j = 0; j < word2.length(); j++)
            prev[j] = word2.length() - j;

        for (int r = word1.length() - 1; r >= 0; r--) {
            curr[word2.length()] = word1.length() - r;
            for (int c = word2.length() - 1; c >= 0; c--) {
                if (word1.charAt(r) == word2.charAt(c))
                    curr[c] = prev[c + 1];
                else
                    curr[c] = Math.min(1 + prev[c], // delete
                            Math.min(1 + prev[c + 1], // replace
                                    1 + curr[c + 1])); // insert
            }
            prev = curr;
            curr = new int[word2.length() + 1];
        }

        return prev[0];
    }
}

// class Solution {
//     public int minDistance(String word1, String word2) {
//         int len1 = word1.length();
//         int len2 = word2.length();

//         int[][] minOperations = new int[len1 + 1][len2 + 1];
//         // Fill in bottom row base cases
//         for (int j = 0; j < word2.length(); j++)
//             minOperations[word1.length()][j] = word2.length() - j;

//         // Fill in rightmost row base cases
//         for (int i = 0; i < word1.length(); i++)
//             minOperations[i][word2.length()] = word1.length() - i;

//         for (int r = len1 - 1; r >= 0; r--) {
//             for (int c = len2 - 1; c >= 0; c--) {
//                 if (word1.charAt(r) == word2.charAt(c))
//                     minOperations[r][c] = minOperations[r + 1][c + 1];
//                 else
//                     minOperations[r][c] = Math.min(1 + minOperations[r + 1][c],
//                             Math.min(1 + minOperations[r + 1][c + 1], 1 + minOperations[r][c + 1]));
//             }
//         }

//         return minOperations[0][0];
//     }
// }

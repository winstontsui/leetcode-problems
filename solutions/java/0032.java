/*
 * Leetcode 32: Longest Valid Parentheses. Java. Hard.
 * O(n) runtime and O(1) space complexity.
 * Uses a dual-pass approach to handle imbalanced parentheses in both directions.
 * Left-to-right pass handles cases where ')' appears before '('.
 * Right-to-left pass handles cases where '(' appears before ')'.
 * Insights: This approach efficiently tracks valid substrings by resetting counts when imbalances are detected.
 * 1/6/2025 Winston Tsui
 */

class Solution {
    public int longestValidParentheses(String s) {
        int longestLen = 0;
        int numOpen = 0;
        int numClosed = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                numOpen++;
            else
                numClosed++;

            if (numOpen == numClosed)
                longestLen = Math.max(longestLen, 2 * numClosed);

            if (numClosed > numOpen) {
                numOpen = 0;
                numClosed = 0;
            }
        }
        numOpen = 0;
        numClosed = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                numOpen++;
            else
                numClosed++;

            if (numOpen == numClosed)
                longestLen = Math.max(longestLen, 2 * numOpen);

            if (numOpen > numClosed) {
                numOpen = 0;
                numClosed = 0;
            }
        }

        return longestLen;
    }
}

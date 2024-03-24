/*
 * Leetcode 22: Generate Parentheses. Java. Medium.
 * O(2^(2n)) runtime and O(n) space complexity. Space complexity is the size of the recursion stack.
 * Backtracking algorithm iterating through all possible combinations of valid parentheses of length n.
 * 3/23/2024 Winston Tsui
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        StringBuilder stack = new StringBuilder();
        backtrack(ans, stack, n, 0, 0);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder stack, int n, int openN, int closeN) {
        // If this combination of parentheses is valid, add it to ans!
        if (n == openN && n == closeN) {
            ans.add(stack.toString());
            return; // Optional
        }

        // I add '(' only when openN, the # of open parentheses we have so far is < n!
        if (openN < n) {
            stack.append('(');
            backtrack(ans, stack, n, openN + 1, closeN);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closeN < openN) {
            stack.append(')');
            backtrack(ans, stack, n, openN, closeN + 1);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}

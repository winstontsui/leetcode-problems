/*
 * Leetcode 1021: Remove Outermost Parentheses. Java. Easy.
 * O(n) runtime and O(1) space complexity. Use a stack mentality: 
 * Keep track of the depth of current parentheses: If the opening parentheses' depth is greater than 1, 
 * include it in the final answer. Similarly, if the closing parentheses depth is greater than 0, include it.
 * 3/7/2024 Winston Tsui
*/

class Solution {
    public String removeOuterParentheses(String s) {
        int currDepth = 0;
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                currDepth++;
                if (currDepth > 0)
                    ans.append('(');
            } else {
                currDepth--;
                if (currDepth > 1)
                    ans.append(')');
            }
        }

        return ans.toString();
    }
}

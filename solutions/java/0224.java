/*
 * Leetcode 224: Basic Calculator. Java. Hard.
 * O(n) runtime and O(d) space complexity, where n is the length of the input string and d is the depth of nested parentheses.
 * Use a stack to manage state (current total and sign) when parentheses are encountered.
 * Multi-digit numbers are handled by parsing them sequentially, and the current sign is applied to maintain correctness.
 * Edge cases such as nested parentheses, spaces, and negative numbers are handled efficiently.
 * 12/6/2024 Winston Tsui
 */

import java.util.Stack;

class Solution {
    public int calculate(String s) {

        int total = 0;
        int currSign = 1; // 1 for positive numbers, -1 for negative numbers
        Stack<int[]> expressions = new Stack<>(); // Stores current total, sign.

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int currInt = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    currInt = currInt * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                total += currInt * currSign;
            } else if (s.charAt(i) == '(') {
                expressions.push(new int[] { total, currSign });
                total = 0;
                currSign = 1;
            } else if (s.charAt(i) == ')') {
                int[] prevExpression = expressions.pop();
                total = total * prevExpression[1] + prevExpression[0];
            } else if (s.charAt(i) == '+')
                currSign = 1;
            else if (s.charAt(i) == '-')
                currSign = -1;
        }
        return total;
    }
}

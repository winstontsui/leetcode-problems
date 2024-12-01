/*
 * Leetcode 2390: Removing Stars from a String. Java. Medium.
 * O(n) runtime and O(n) space complexity, where n is the length of the input string.
 * The problem is solved using a stack to simulate the removal of characters based on stars (*).
 * For each character, add it to the stack unless it's a star, in which case the top element is removed.
 * After processing the string, the stack is converted to the final result by reversing its order.
 * 12/1/2024 Winston Tsui
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeStars(String s) {
        // Use a stack to keep track of characters that remain after processing stars
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder finalStr = new StringBuilder();

        // Create stack to track the string
        for (Character c : s.toCharArray()) {
            if (c != '*')
                stack.push(c);
            else
                stack.pop();
        }

        // Build the final string from the stack
        while (!stack.isEmpty())
            finalStr.append(stack.pop());

        // Reverse the result because the stack stores characters in reverse order
        return finalStr.reverse().toString();
    }
}

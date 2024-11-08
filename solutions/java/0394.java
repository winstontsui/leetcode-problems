/*
 * LeetCode 394: Decode String. Java. Medium.
 * O(n) time complexity and O(n) space complexity, where n is the length of the input string.
 * Uses a stack to manage nested encoded patterns, pushing characters until reaching ']'.
 * When ']' is encountered, pops characters to form the current substring and repeats it k times.
 * Build final result by combining all items left in the stack.
 * 11/8/2024 Winston Tsui
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String decodeString(String s) {
        // Stack to store intermediate strings
        Deque<String> stack = new ArrayDeque<>();

        for (Character c : s.toCharArray()) {
            // Build the string to be repeated until encountering '['
            if (c != ']')
                stack.push(c + "");
            else {
                StringBuilder currString = new StringBuilder();
                while (!stack.peek().equals("["))
                    currString.insert(0, stack.pop());

                // Removes "[".
                stack.pop();

                // Build the repeat count k for currString
                StringBuilder kString = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0)))
                    kString.insert(0, stack.pop().charAt(0));
                int k = Integer.parseInt(kString.toString());

                // Repeat `currString` k times and push back to stack
                String finalString = currString.toString().repeat(k);

                stack.push(finalString.toString());

            }
        }
        // Build the final result from all items left in the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}

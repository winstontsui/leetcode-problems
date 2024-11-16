/*
 * Leetcode 388: Longest Absolute File Path. Java. Medium.
 * O(n) runtime and O(d) space complexity, where n is the length of the input string and d is the maximum depth of the file system.
 * The problem is solved using a stack to maintain cumulative path lengths at each directory level. 
 * For each file, compute the full path length using the stack and update the maximum length if it's the longest path seen so far.
 * 11/15/2024 Winston Tsui
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int lengthLongestPath(String input) {
        /*
         * Stack's size measures how deep we are in the subdirectories.
         * Depth is calculated by counting '\t'.
         */

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int maxLength = 0;

        for (String line : input.split("\n")) {
            // Calculate current depth (number of '\t')
            int currentDepth = line.lastIndexOf("\t") + 1;

            // Pop from the stack until it matches the current depth
            while (stack.size() > currentDepth + 1)
                stack.pop();

            if (line.contains(".")) // If it's is a file: Calculate pull path length. Subtract currentDepth to get rid of \t.
                maxLength = Math.max(maxLength, stack.peek() + line.length() - currentDepth);
            else
                stack.push(stack.peek() + line.length() - currentDepth + 1);

        }
        return maxLength;

    }
}

/*
 * Leetcode 71: Simplify Path. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * Uses a stack to process directory components while handling ".." (move up), "." (current directory), and empty segments.
 * Splits the input path by "/", processes valid components, and reconstructs the canonical path.
 * Key Insight: Ensures root "/" is always present and correctly removes unnecessary trailing slashes.
 * 2/15/2025 Winston Tsui
*/

import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        StringBuilder ans = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        stack.push("/");
        String[] split = path.split("/");

        for (int i = 0; i < split.length; i++) {
            String curr = split[i];
            if (curr.equals(".") || curr.equals("") || curr.equals("..") && stack.size() == 1)
                continue;

            if (curr.equals(".."))
                stack.pop();
            else
                stack.push(curr + "/");
        }

        boolean sizeIsOne = stack.size() == 1;

        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return sizeIsOne ? ans.toString() : ans.toString().substring(0, ans.length() - 1);
    }
}

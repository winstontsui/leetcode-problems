/*
 * Leetcode 84: Largest Rectangle in Histogram. Java. Hard.
 * O(n) runtime and O(n) space complexity using a monotonic increasing stack.
 * For each bar in the histogram, computes the largest rectangle that includes that bar by determining its width using the stack.
 * Ensures all bars are processed by adding a dummy bar of height 0 at the end.
 * TODO: Revisit this problem.
 * Insights: Uses the stack to keep track of bar indices with increasing heights, efficiently determining left and right bounds for rectangles.
 * 1/24/2025
 */

import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>(); // Monotonic increasing stack of indicies
        int largestArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int currHeight = i == heights.length ? 0 : heights[i]; // Purpose is to ensure all elements are popped at
                                                                   // the end
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                largestArea = Math.max(largestArea, height * width);
            }
            stack.push(i);
        }
        return largestArea;
    }
}

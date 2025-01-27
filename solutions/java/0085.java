/*
 * Leetcode 85: Maximal Rectangle. Java. Hard.
 * O(m * n) runtime and O(n) space complexity.
 * Transform the matrix into histograms row by row, treating each column as a histogram bar.
 * Use a Monotonic Stack to calculate the largest rectangle in a histogram for each row in O(n) time.
 * Key Insight: Adding a dummy bar of height 0 ensures all histogram bars are processed correctly.
 * Tricky Part: Efficiently handle the histogram calculation while maintaining edge cases (e.g., resetting for '0').
 * 1/26/2025 Winston Tsui
*/

import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Create histogram of number of '1's up to the current row, then calculate
        // largest rectangle from it.

        int maxRectangle = 0;
        int[] histogram = new int[matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                // Build the histogram for the current row.
                // Increment height for '1's, reset to 0 for '0's.
                if (matrix[r][c] == '1')
                    histogram[c]++;
                else
                    histogram[c] = 0; // Reset this histogram column.
            }
            maxRectangle = Math.max(maxRectangle, calculateMax(histogram));
        }
        return maxRectangle;
    }

    private int calculateMax(int[] histogram) {
        int maxArea = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= histogram.length; i++) {
            int currHeight = i == histogram.length ? 0 : histogram[i];
            while (!deque.isEmpty() && currHeight < histogram[deque.peek()]) {
                // Pop bars from the stack while the current bar is shorter than the top of the stack.
                // This indicates that the rectangle for the popped bar ends at the current index.
                int height = histogram[deque.pop()];
                int width = deque.isEmpty() ? i : i - deque.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            deque.push(i);
        }
        return maxArea;

    }
}

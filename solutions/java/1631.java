/*
 * Leetcode 1631: Path With Minimum Effort. Java. Medium.
 * O(m * n * log(m * n)) runtime and O(m * n) space complexity.
 * Uses Dijkstra's algorithm with a min-heap priority queue to find the path from the top-left to the bottom-right corner of the grid.
 * Maintain a minimum effort array to track the smallest effort required to reach each cell.
 * Insights: The algorithm prioritizes cells based on the smallest effort and avoids redundant work by skipping paths with higher efforts.
 * 12/22/2024 Winston Tsui
 */

import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {

        // Distance array to track the minimum effort to each cell
        int[][] minimumEffort = new int[heights.length][heights[0].length];

        // Priority queue (min-heap) to process cells in increasing order of effort required
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> (a[2] - b[2])); // [r, c, effort required]
        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        // Initialize all cells with maximum possible effort
        for (int[] row : minimumEffort)
            Arrays.fill(row, Integer.MAX_VALUE);

        // Start from the top-left corner with 0 effort
        heap.add(new int[] { 0, 0, 0 });
        minimumEffort[0][0] = 0;

        while (!heap.isEmpty()) {
            int[] currCell = heap.remove();
            int currR = currCell[0];
            int currC = currCell[1];

            // If we reach the bottom-right corner, return the effort
            if (currR == heights.length - 1 && currC == heights[0].length - 1)
                return currCell[2];

            for (int[] direction : directions) {
                int neighborR = currR + direction[0];
                int neighborC = currC + direction[1];

                if (neighborR >= 0 && neighborC >= 0 && neighborR < heights.length && neighborC < heights[0].length) {
                    // Calculate the effort to move to this neighbor
                    int newEffort = Math.max(currCell[2],
                            Math.abs(heights[neighborR][neighborC] - heights[currR][currC]));
                    // If this path offers a smaller effort, update and push to the heap
                    if (newEffort < minimumEffort[neighborR][neighborC]) {
                        minimumEffort[neighborR][neighborC] = newEffort;
                        heap.add(new int[] { neighborR, neighborC, newEffort });
                    }
                }
            }
        }
        return -1;
    }
}

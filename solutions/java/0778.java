/*
 * Leetcode 778: Swim in Rising Water. Java. Hard.
 * O(n^2 * log(n)) runtime and O(n^2) space complexity.
 * Uses Dijkstra's algorithm with a min-heap priority queue to find the minimum time required to traverse from the top-left to the bottom-right corner of the grid.
 * The priority queue ensures that cells are processed in ascending order of the water depth, and a visited array prevents redundant processing.
 * Insights: By processing cells in order of their minimum depth, the algorithm efficiently guarantees the optimal path to the destination.
 * 12/24/2024 Winston Tsui
 */

import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        Queue<int[]> heap = new PriorityQueue<>((a, b) -> (a[2] - b[2])); // [r, c, waterDepth]

        // Time array to track the minimum time required to reach each cell, a visited array is sufficient though
        int[][] time = new int[n][n];
        heap.add(new int[] { 0, 0, grid[0][0] });

        for (int[] row : time)
            Arrays.fill(row, Integer.MAX_VALUE);
        time[0][0] = grid[0][0]; // min amount of time to reach position (0, 0).

        while (!heap.isEmpty()) {
            int[] curr = heap.remove();
            int r = curr[0];
            int c = curr[1];
            int depth = curr[2];

            // If I reach the bottom right corner
            if (r == n - 1 && c == n - 1)
                return depth;

            for (int[] dir : dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                // If the neighbor is within bounds
                if (newR >= 0 && newC >= 0 && newR < n && newC < n) {
                    // If a smaller time is found for the neighbor, update and add to heap
                    int newDepth = Math.max(grid[newR][newC], depth);

                    if (newDepth < time[newR][newC]) {
                        heap.add(new int[] { newR, newC, newDepth });
                        time[newR][newC] = newDepth;
                    }
                }
            }
        }
        return -1;
    }
}

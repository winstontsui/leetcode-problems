/*
 * Leetcode 1091: Shortest Path in Binary Matrix. Java. Medium.
 * O(n^2) runtime and O(n^2) space complexity.
 * Uses BFS to explore all possible paths from the top-left to the bottom-right cell.
 * Explores all 8 directions and marks cells as visited immediately upon adding them to the queue.
 * Insights: BFS ensures the shortest path in an unweighted grid and avoids redundant processing by marking neighbors as visited early.
 * 12/19/2024 Winston Tsui
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int size = grid.length;
        if (grid[0][0] == 1 || grid[size - 1][size - 1] == 1)
            return -1;

        int[][] dirs = new int[][] { { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { 0, -1 }, { -1, 0 }, { 1, 0 },
                { 0, 1 } };

        Deque<int[]> deque = new ArrayDeque<>(); // BFS queue: stores [x, y, path_length]
        deque.add(new int[] { 0, 0, 1 }); // Start from top-left with path length 1

        // Mark the starting cell as visited
        grid[0][0] = 1;

        while (!deque.isEmpty()) {
            int[] curr = deque.remove();

            if (curr[0] == size - 1 && curr[1] == size - 1)
                return curr[2];

            for (int[] dir : dirs) {
                int neighborX = curr[0] + dir[0];
                int neighborY = curr[1] + dir[1];

                // Check if the neighboring cell is valid and unvisited
                if (neighborX >= 0 && neighborY >= 0 && neighborX < size && neighborY < size
                        && grid[neighborX][neighborY] != 1) {
                    deque.add(new int[] { neighborX, neighborY, curr[2] + 1 });
                    grid[neighborX][neighborY] = 1;
                }
            }
        }
        return -1;
    }
}

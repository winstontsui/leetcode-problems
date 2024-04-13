/*
 * Leetcode 994: Rotting Oranges. Java. Medium.
 * O(n*m) runtime. O(m*n) spacetime if all oranges are rotten from the start.
 * Use a deque to keep track of rotten oranges' positions and use a layered bfs traversal
 * algorithm to keep track of time and mark oranges as rotten.
 * 4/13/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;

        Deque<Integer[]> rottingPos = new ArrayDeque<>(); // Keeps track of rotting oranges' positions.
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                if (grid[r][c] == 2)
                    rottingPos.add(new Integer[] { r, c });

        // Bfs with timekeeping for each iteration.
        while (!rottingPos.isEmpty()) {
            int size = rottingPos.size();
            boolean hasRotten = false; // Checks if an orange has rotten this round for time purposes.

            // Traverses grid by level
            for (int i = 0; i < size; i++) {
                Integer[] rotPos = rottingPos.remove();
                for (int[] dir : directions) {
                    int x = rotPos[0] + dir[0];
                    int y = rotPos[1] + dir[1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1)
                        continue;
                    grid[x][y] = 2;
                    rottingPos.add(new Integer[] { x, y });
                    hasRotten = true;
                }
            }
            // If no oranges rotted this round, don't increment time.
            if (hasRotten)
                time++;
        }

        // If a fresh orange remains, return -1.
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                if (grid[r][c] == 1)
                    return -1;

        return time;

    }

    // Explores grid down, up, left and right.
    private int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

}

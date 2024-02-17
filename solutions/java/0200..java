/*
 * Leetcode 200: Number of Islands. Java. Medium.
 * O(n*m) runtime and O(min(m, n)) spacetime.
 * BFS problem keeping track of which islands I have visited using provided grid.
 * Use int[][] directions to move in all directions, and if it is a valid location,
 * mark it as visited within the bfs.
 * 2/17/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;

        // '2' means that I have checked and counted grid[r][c] before as an island.
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '2'; // Marks position as visited.
                    numIslands++;
                    bfs(grid, r, c);
                }
            }
        }

        return numIslands;
    }

    private int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    private void bfs(char[][] grid, int r, int c) {
        Queue<Integer[]> neighbors = new ArrayDeque<Integer[]>();
        neighbors.add(new Integer[] { r, c });

        while (!neighbors.isEmpty()) {
            Integer[] pos = neighbors.remove();

            for (int[] direction : directions) {
                int x = pos[0] + direction[0];
                int y = pos[1] + direction[1];

                // Mark valid neighboring land as part of current island.
                // Valid land must also be added to neighbors for checking.
                if (x > -1 && x < grid.length && y > -1 && y < grid[0].length && grid[x][y] == '1') {
                    neighbors.add(new Integer[] { x, y });
                    grid[x][y] = '2';
                }
            }
        }

    }
}

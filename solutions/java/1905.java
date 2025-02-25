/*
 * Leetcode 1905: Count Sub-Islands. Java. Medium.
 * O(M × N) runtime and O(M × N) space complexity.
 * Uses DFS to traverse islands in `grid2`, checking if they exist fully in `grid1`.
 * An island is a sub-island if every `1` in `grid2` corresponds to a `1` in `grid1`.
 * 2/25/2025 Winston Tsui
*/

import java.util.*;

class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        HashSet<String> visited = new HashSet<>(); // 1,1
        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int numIslands = 0;

        // Go through grid2, do dfs on unvisited nodes.
        for (int r = 0; r < grid2.length; r++)
            for (int c = 0; c < grid2[0].length; c++)
                if (grid2[r][c] == 1 && !visited.contains(r + "," + c) && dfs(directions, grid1, grid2, r, c, visited))
                    numIslands++;

        return numIslands;
    }

    // DFS to check if an island in grid2 is a sub-island of grid1
    private boolean dfs(int[][] directions, int[][] grid1, int[][] grid2, int r, int c, HashSet<String> visited) {
        boolean isSubIsland = grid1[r][c] == 1;

        visited.add(r + "," + c);
        for (int[] direction : directions) {
            int newX = r + direction[0];
            int newY = c + direction[1];
            if (newX > -1 && newY > -1 && newX < grid2.length && newY < grid2[0].length && grid2[newX][newY] == 1
                    && !visited.contains(newX + "," + newY)) {
                if (!dfs(directions, grid1, grid2, newX, newY, visited))
                    isSubIsland = false;
            }
        }
        return isSubIsland;
    }
}

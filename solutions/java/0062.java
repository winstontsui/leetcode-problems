/*
 * Leetcode 62: Unique Paths. Java. Medium.
 * Captivating Problem. O(m*n) runtime and O(m*n) space complexity.
 * Use a 2D array to store number of unique paths at that particular point. 
 * Returns the bottom right element of the grid.
 * However, there is a more efficient O(n) space complexity solution.
 * 3/2/2024 Winston Tsui
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];

        // Initialize first row and column to 1 as there are only one path that can
        // reach it.
        for (int r = 0; r < grid.length; r++)
            grid[r][0] = 1;
        for (int c = 0; c < grid[0].length; c++)
            grid[0][c] = 1;

        for (int r = 1; r < grid.length; r++) {
            for (int c = 1; c < grid[0].length; c++)
                grid[r][c] = grid[r - 1][c] + grid[r][c - 1];
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}

/*
 * Leetcode 62: Unique Paths. Java. Medium.
 * Captivating Problem. O(m*n) runtime and O(n) space complexity.
 * The number of unique paths at a given point is the sum of the number of unique paths at the point above it, 
 * which is grid[c] in the optimized solution, plus the previous column, which is grid[c-1].
 * 3/2/2024 Winston Tsui
*/

// Optimal O(n) space complexity solution
class Solution {
    public int uniquePaths(int m, int n) {
        int[] grid = new int[n];
        for (int i = 0; i < n; i++)
            grid[i] = 1;

        for (int r = 1; r < m; r++)
            for (int c = 1; c < n; c++)
                grid[c] += grid[c - 1];

        return grid[n - 1];
    }
}

// // Suboptimal O(n^2) space complexity
// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] grid = new int[m][n];

//         // Initialize first row and column to 1 as there are only one path that can
//         // reach it.
//         for (int r = 0; r < grid.length; r++)
//             grid[r][0] = 1;
//         for (int c = 0; c < grid[0].length; c++)
//             grid[0][c] = 1;

//         for (int r = 1; r < grid.length; r++) {
//             for (int c = 1; c < grid[0].length; c++)
//                 grid[r][c] = grid[r - 1][c] + grid[r][c - 1];
//         }

//         return grid[grid.length - 1][grid[0].length - 1];
//     }
// }

/*
 * Leetcode 542: 01 Matrix. Java. Medium.
 * O(m * n) runtime and O(m * n) space complexity.
 * Use BFS starting from all 0s in the matrix and explore neighbors using a queue.
 * Initialize the queue with all 0s and mark 1s as unvisited (-1) to distinguish them.
 * The BFS ensures that each cell's distance to the nearest 0 is updated in a layered manner.
 * Insights: Using BFS guarantees the shortest path, and marking cells as visited prevents redundant operations.
 * 12/17/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        Deque<int[]> deque = new ArrayDeque<>();

        // Initialize the queue and mark unprocessed cells as -1
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0)
                    deque.add(new int[] { r, c }); // Start BFS from 0s
                else
                    mat[r][c] = -1; // Mark 1s as unvisited

            }
        }

        while (!deque.isEmpty()) {
            int[] curr = deque.remove();
            int x = curr[0];
            int y = curr[1];
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check bounds and unvisited cells
                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && mat[newX][newY] == -1) {
                    mat[newX][newY] = mat[x][y] + 1;
                    deque.add(new int[] { newX, newY });
                }

            }
        }
        return mat;
    }
}

// // DP solution: Even better O(1) space complexity
// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int rows = mat.length;
//         int cols = mat[0].length;
//         int maxDist = rows + cols;

//         // Go top left to bottom right, calculating distance.
//         for (int r = 0; r < rows; r++) {
//             for (int c = 0; c < cols; c++) {
//                 if (mat[r][c] != 0) {
//                     int left = c > 0 ? mat[r][c - 1] : maxDist;
//                     int top = r > 0 ? mat[r - 1][c] : maxDist;
//                     mat[r][c] = Math.min(left, top) + 1;
//                 }
//             }
//         }

//         // Go bottom right to top left, calculating distance.
//         for (int r = rows - 1; r >= 0; r--) {
//             for (int c = cols - 1; c >= 0; c--) {
//                 if (mat[r][c] != 0) {
//                     int right = c < cols - 1 ? mat[r][c + 1] : maxDist;
//                     int bottom = r < rows - 1 ? mat[r + 1][c] : maxDist;
//                     mat[r][c] = Math.min(mat[r][c], Math.min(right, bottom) + 1);
//                 }
//             }
//         }
//         return mat;
//     }
// }

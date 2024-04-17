/*
 * Leetcode 48: Rotate Image. Java. Medium.
 * O(n*m) runtime and O(1) space complexity.
 * Convoluted, tricky problem. Approach 1: Reverse in a layered manner starting from outer layer. 
 * Swap elements in a counterclockwise manner 4 at a time, using an inner loop to increment in each layer.
 * Approach 2: Transpose across diagonal and reflect (reverse) elements in every row of matrix.
 * 4/16/2024 Winston Tsui
*/

class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length - 1;
        int left = 0;
        int right = len;

        while (left < right) {
            int top = left;
            int bottom = right;
            for (int i = 0; i < len - 2 * left; i++) {
                // Go in reverse order to minimize usage of temp variable.
                int temp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }
            left++;
            right--;
        }

        // // Approach 2: Transpose across diagonal and reflect (reverse) elements in every row of matrix.
        // // Transpose elements along the top-left and bottom-right diagonal.
        // for (int r = 0; r < matrix.length; r++) {
        //     for (int c = r; c < matrix[0].length; c++) {
        //         int temp = matrix[r][c];
        //         matrix[r][c] = matrix[c][r];
        //         matrix[c][r] = temp;
        //     }
        // }

        // // Reverse contents of every row in matrix from left to right.
        // for (int r = 0; r < matrix.length; r++) {
        //     for (int c = 0; c < matrix[0].length / 2; c++) {
        //         int temp = matrix[r][c];
        //         matrix[r][c] = matrix[r][matrix[0].length - 1 - c];
        //         matrix[r][matrix[0].length - 1 - c] = temp;
        //     }
        // }
    }
}

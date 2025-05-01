/*
 * Leetcode 304: Range Sum Query 2D - Immutable. Java. Medium.
 * O(1) query time and O(M × N) preprocessing time and space.
 * Make a 2D prefix sum matrix with initial padding of 0s.
 * A cell at (r+1, c+1) stores the sum of all elements from (0,0) to (r,c).
 * 4/30/2025 Winston Tsui
 */

class NumMatrix {
    int[][] newMatrix;

    public NumMatrix(int[][] matrix) {
        newMatrix = new int[matrix.length + 1][matrix[0].length + 1]; // Initial row and column padding of 0

        // Calculates sum of numbers from (0,0) to (r, c)
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                newMatrix[r + 1][c + 1] = newMatrix[r][c + 1] // Above
                        + newMatrix[r + 1][c] // Left
                        - newMatrix[r][c] // Double counted
                        + matrix[r][c]; // Current element
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return newMatrix[row2 + 1][col2 + 1] // Sum from (0,0) to this point
                - newMatrix[row1][col2 + 1] // Above
                - newMatrix[row2 + 1][col1] // Left
                + newMatrix[row1][col1]; // Doubly removed
    }
}

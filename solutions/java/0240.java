/*
 * LeetCode 240: Search a 2D Matrix II. Java. Medium.
 * O(m + n) time complexity where m is the number of rows and n is the number of columns.
 * O(1) space complexity as it uses only a constant amount of extra space.
 * This algorithm starts from the top right corner of the matrix, where each element has a unique direction:
 * - If the target is greater than the current element, move down to the next row (increase row).
 * - If the target is smaller, move left to the previous column (decrease column).
 * This efficiently finds the target or confirms its absence without scanning all elements.
 * 11/12/2024 Winston Tsui
 */


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;

        // Starting from the top right cell, if target is greater than it move down
        // and if target is less than it move left.
        while (column > -1 && row < matrix.length) {
            if (matrix[row][column] == target)
                return true;
            else if (target > matrix[row][column])
                row += 1; // move down
            else
                column -= 1; // move left
        }
        return false;
    }
}


/*
 * LeetCode 54: Spiral Matrix. Java. Medium.
 * O(m * n) runtime and O(m * n) space complexity.
 * Traverse a 2D matrix in a spiral order (clockwise from top-left corner),
 * appending each element to a result list. Use four boundaries (top, bottom, left, right)
 * to control the traversal directions (right, down, left, up). After each pass in a direction,
 * adjust the boundary inward to avoid revisiting elements. Stop when boundaries overlap.
 * 10/27/2024 Winston Tsui
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int sRow = 0;
        int sColumn = 0;
        int fRow = matrix.length - 1;
        int fColumn = matrix[0].length - 1;
        List<Integer> spiralOrder = new ArrayList<>();

        while (sColumn <= fColumn && sRow <= fRow) {
            // Right
            for (int c = sColumn; c <= fColumn; c++)
                spiralOrder.add(matrix[sRow][c]);
            sRow += 1;
            // Down
            for (int r = sRow; r <= fRow; r++)
                spiralOrder.add(matrix[r][fColumn]);
            fColumn -= 1;

            // Left
            if (sRow <= fRow)
                for (int c = fColumn; c >= sColumn; c--)
                    spiralOrder.add(matrix[fRow][c]);
            fRow -= 1;

            // Up
            if (sColumn <= fColumn)
                for (int r = fRow; r >= sRow; r--)
                    spiralOrder.add(matrix[r][sColumn]);
            sColumn += 1;
        }
        return spiralOrder;
    }
}

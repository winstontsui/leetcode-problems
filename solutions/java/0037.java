/*
 * Leetcode 37: Sudoku Solver. Java. Hard.
 * O(9^m) runtime and O(27) space complexity, where m is the number of empty cells.
 * This solution employs backtracking with HashMaps to track constraints for rows, columns, and sub-boxes.
 * The algorithm iteratively places digits 1-9 in empty cells, backtracking when constraints are violated, until a valid solution is found.
 * Insights: Using HashMaps to store constraints improves the efficiency of validation checks compared to direct board scanning.
 * 12/29/2024 Winston Tsui
 */

import java.util.*;

class Solution {
    public void solveSudoku(char[][] board) {
        HashMap<Integer, HashSet<Integer>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> cols = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> subBoxes = new HashMap<>();

        // Populate the hash maps with the initial state of the board
        for (int i = 0; i < 9; i++){
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            subBoxes.put(i, new HashSet<>());
        }

        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                if (board[r][c] != '.'){
                    int subBoxIdx = c/3 + (r/3 * 3);
                    rows.get(r).add(board[r][c] - '0');
                    cols.get(c).add(board[r][c] - '0');
                    subBoxes.get(subBoxIdx).add(board[r][c] - '0');
                }
            }
        }
        backtrack(board, 0, 0, rows, cols, subBoxes);
    }
    private boolean backtrack(char[][] board, int row, int col, HashMap<Integer, HashSet<Integer>> rows, HashMap<Integer, HashSet<Integer>> cols, HashMap<Integer, HashSet<Integer>> subBoxes){
        // Reached end of current row
        if (col == board[0].length){
            col = 0;
            row++;
        }

        // Completed all cells
        if (row == board.length)
            return true;

        // This spot is already filled
        if (board[row][col] != '.')
            return backtrack(board, row, col + 1, rows, cols, subBoxes);

        int subBoxIdx = col/3 + (row/3 * 3);

        for (int i = 1; i <= 9; i++){
            if (isValid(board, i, row, col, subBoxIdx, rows, cols, subBoxes)){
                // Try this number if it is valid.
                board[row][col] = (char) ('0' + i);
                rows.get(row).add(i);
                cols.get(col).add(i);
                subBoxes.get(subBoxIdx).add(i);

                if (backtrack(board, row, col+1, rows, cols, subBoxes))
                    return true;

                // Backtrack if this combination fails the rules
                board[row][col] = '.';
                rows.get(row).remove(i);
                cols.get(col).remove(i);
                subBoxes.get(subBoxIdx).remove(i);
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int row, int col, int subBoxIdx, HashMap<Integer, HashSet<Integer>> rows, HashMap<Integer, HashSet<Integer>> cols, HashMap<Integer, HashSet<Integer>> subBoxes){
        return !rows.get(row).contains(i) && !cols.get(col).contains(i) && !subBoxes.get(subBoxIdx).contains(i);
    }
}

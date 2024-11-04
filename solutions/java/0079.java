/*
 * Leetcode 79: Word Search. Java. Medium.
 * O(m * n * 4^L) time complexity, where m and n are grid dimensions, and L is the word length.
 * Uses backtracking with DFS to check if the word exists in the grid, moving in four directions.
 * Temporarily mark visited cells to prevent reuse in the same path.
 * Returns true if any path spells the word, false otherwise.
 * 11/2/2024 Author
 */

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                // If it matches first character of word, begin dfs.
                if (board[r][c] == word.charAt(0) && dfs(board, word, r, c, 0))
                    return true;
            }
        }

        return false;
    }

    // Determines if word can exist starting from word[r][c].
    private boolean dfs(char[][] board, String word, int r, int c, int currIndex) {
        // Base case
        if (currIndex == word.length())
            return true;
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || word.charAt(currIndex) != board[r][c]
                || board[r][c] == '@')
            return false;

        // Mark the cell as visited by temporarily changing its value
        char originalChar = board[r][c];
        board[r][c] = '@';

        boolean ans = dfs(board, word, r + 1, c, currIndex + 1) || dfs(board, word, r, c + 1, currIndex + 1)
                || dfs(board, word, r - 1, c, currIndex + 1) || dfs(board, word, r, c - 1, currIndex + 1);

        // Backtrack by changing character to original character.
        board[r][c] = originalChar;

        return ans;
    }
}

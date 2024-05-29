/*
 * Leetcode 130: Surrounded Regions. Java. Medium.
 * O(m*n) runtime and O(1) space complexity.
 * Start with the border elements: Perform dfs, marking valid elements as 'T' for temporary.
 * After dfs finishes, mark all 'O' as 'X' and all 'T' as 'O'.
 * 5/28/2024 Winston Tsui
*/

class Solution {
    public void solve(char[][] board) {

        // Mark border elements with 'O' as 'T' and perform dfs
        for (int r = 0; r < board.length; r++) {
            if (board[r][0] == 'O')
                dfs(r, 0, board);
            if (board[r][board[0].length - 1] == 'O')
                dfs(r, board[0].length - 1, board);
        }

        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == 'O')
                dfs(0, c, board);
            if (board[board.length - 1][c] == 'O')
                dfs(board.length - 1, c, board);
        }

        // Revert changed and unchanged elements back
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O')
                    board[r][c] = 'X';
                if (board[r][c] == 'T')
                    board[r][c] = 'O';
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {
        if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || board[r][c] != 'O')
            return;

        // Mark this spot as temporary, to be reverted later.
        board[r][c] = 'T';
        dfs(r + 1, c, board);
        dfs(r - 1, c, board);
        dfs(r, c + 1, board);
        dfs(r, c - 1, board);
    }
}

/*
 * Leetcode 51: N-Queens. Java. Hard.
 * O(n!) runtime and O(n^2) space complexity for board representation and auxiliary arrays.
 * Uses backtracking to place queens on an n x n chessboard such that no two queens attack each other.
 * Auxiliary arrays track the columns, main diagonals, and anti-diagonals to efficiently check for conflicts.
 * Insights: The board is represented as a List of Lists, and the solution constructs the final output as List of Strings.
 * 1/1/2025 Winston Tsui
 */

import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        // Prefill curr to be all '.'
        List<List<Character>> curr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            curr.add(new ArrayList<>());
            for (int j = 0; j < n; j++)
                curr.get(i).add('.');
        }

        // Auxiliary arrays
        boolean[] cols = new boolean[n];
        boolean[] diags1 = new boolean[2 * n - 1]; // r - c + (n - 1)
        boolean[] diags2 = new boolean[2 * n - 1]; // r + c

        backtrack(ans, 0, n, curr, cols, diags1, diags2);
        return ans;
    }

    private void backtrack(List<List<String>> ans, int r, int n, List<List<Character>> curr, boolean[] cols,
            boolean[] diags1, boolean[] diags2) {
        if (r == n) {
            List<String> board = new ArrayList<>();
            for (List<Character> row : curr) {
                StringBuilder sb = new StringBuilder();
                for (Character ch : row)
                    sb.append(ch);
                board.add(sb.toString());
            }

            ans.add(board);
            return;
        }

        for (int c = 0; c < n; c++) {
            int diag1Index = r - c + (n - 1);
            int diag2Index = r + c;

            if (!cols[c] && !diags1[diag1Index] && !diags2[diag2Index]) {
                curr.get(r).set(c, 'Q');
                cols[c] = diags1[diag1Index] = diags2[diag2Index] = true;

                backtrack(ans, r + 1, n, curr, cols, diags1, diags2);

                curr.get(r).set(c, '.');
                cols[c] = diags1[diag1Index] = diags2[diag2Index] = false;
            }
        }
    }
}

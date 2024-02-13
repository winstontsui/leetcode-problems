/*
 * Leetcode 417: Pacific Atlantic Water Flow. Java. Medium.
 * Difficult BFS problem. O(n*m) runtime and O(n*m) space complexity.
 * Must keep track of which cells can go into the Pacific and Atlantic oceans, 
 * respectively, and then return the cells that can go into both in a list.
 * 2/8/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;

        Deque<Integer[]> qPac = new ArrayDeque<Integer[]>();
        Deque<Integer[]> qAtl = new ArrayDeque<Integer[]>();
        boolean[][] seenPac = new boolean[rows][cols];
        boolean[][] seenAtl = new boolean[rows][cols];

        // Initialize seenPac and seenAtl.
        for (int r = 0; r < rows; r++) {
            qPac.add(new Integer[] { r, 0 });
            qAtl.add(new Integer[] { r, cols - 1 });
            seenPac[r][0] = true;
            seenAtl[r][cols - 1] = true;
        }

        for (int c = 0; c < cols; c++) {
            qPac.add(new Integer[] { 0, c });
            qAtl.add(new Integer[] { rows - 1, c });
            seenPac[0][c] = true;
            seenAtl[rows - 1][c] = true;
        }

        // Find values in heights that I can go to, traversing through heights.
        bfs(heights, seenPac, qPac);
        bfs(heights, seenAtl, qAtl);

        // Determine which cells can flow to both oceans and add to ans to be returned.
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (seenPac[r][c] && seenAtl[r][c])
                    ans.add(Arrays.asList(r, c));
            }
        }

        return ans;

    }

    // All the possible directions-- up, down, left and right in heights[][].
    private static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    private void bfs(int[][] heights, boolean[][] seen, Queue<Integer[]> q) {
        while (!q.isEmpty()) {
            Integer[] curr = q.remove();
            int x = curr[0];
            int y = curr[1];

            // Now explore neighbors. Have to go up, down, left and right in all directions.
            for (int[] currDir : dir) {
                int adjustedx = x + currDir[0];
                int adjustedy = y + currDir[1];

                if (adjustedx < 0 || adjustedy < 0 || adjustedx == heights.length || adjustedy == heights[0].length)
                    continue;
                if (seen[adjustedx][adjustedy] || heights[adjustedx][adjustedy] < heights[x][y])
                    continue;

                // If this is a valid neighbor, add this coordinate here and mark as seen.
                q.add(new Integer[] { adjustedx, adjustedy });
                seen[adjustedx][adjustedy] = true;
            }
        }
    }
}

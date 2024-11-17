/*
 * Leetcode 959: Regions Cut by Slashes. Java. Medium.
 * O(n^2) runtime and O(n^2) space complexity, where n is the length of the grid's side.
 * The problem is solved by expanding the input grid to a 3x larger grid, where slashes ('/' and '\') are represented as blocked cells.
 * A DFS is used to traverse the enlarged grid, marking connected regions and counting the total number of distinct regions.
 * 11/16/2024 Winston Tsui
 */

 class Solution {
    public int regionsBySlashes(String[] grid) {
        int gridRows = grid.length;
        int gridCols = grid[0].length();
        int gridLgRows = grid.length * 3;
        int gridLgCols = grid[0].length() * 3;

        // Translate grid into 3x bigger grid. 1 represents "blocked" unpassable areas, 0 otherwise.
        int[][] gridLg = new int[gridLgRows][gridLgCols];
        
        for (int r = 0; r < gridRows; r++) {
            for (int c = 0; c < gridCols; c++) {
                int rLg = r * 3;
                int cLg = c * 3;
                if (grid[r].charAt(c) == '/') {
                    gridLg[rLg][cLg + 2] = 1;
                    gridLg[rLg + 1][cLg + 1] = 1;
                    gridLg[rLg + 2][cLg] = 1;
                } else if (grid[r].charAt(c) == '\\') {
                    gridLg[rLg][cLg] = 1;
                    gridLg[rLg + 1][cLg + 1] = 1;
                    gridLg[rLg + 2][cLg + 2] = 1;
                }
            }
        }

        // Perform dfs on each element in bigger grid, counting number of regions.
        int numRegions = 0;
        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        for (int r = 0; r < gridLgRows; r++) {
            for (int c = 0; c < gridLgCols; c++) {
                // If I have not traversed through this region, increment numRegions
                if (gridLg[r][c] != 1) {
                    dfs(gridLg, r, c, directions);
                    numRegions++;
                }

            }
        }

        // Return number of regions
        return numRegions;
    }

    // Mark region's neighbors as visited so to not double count.
    private void dfs(int[][] gridLg, int r, int c, int[][] directions) {
        if (r < 0 || c < 0 || r == gridLg.length || c == gridLg[0].length || gridLg[r][c] == 1)
            return;

        // Mark this grid as visited.
        gridLg[r][c] = 1;

        for (int[] direction : directions) {
            int neighborR = direction[0] + r;
            int neighborC = direction[1] + c;
            dfs(gridLg, neighborR, neighborC, directions);
        }
    }

}

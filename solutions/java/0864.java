/*
 * Leetcode 864: Shortest Path to Get All Keys. Java. Hard.
 * O(2^k * m * n) runtime and O(2^k * m * n) space complexity, where k is the number of keys, 
 * and m, n are the grid dimensions.
 * Uses BFS to explore all possible states (grid position and collected keys) to find the 
 * shortest path to collect all keys. A bitmask is used to represent the collected keys, 
 * and the state is tracked in a visited set to avoid redundant computations.
 * Insights: BFS ensures the shortest path is found, and the bitmask allows efficient tracking 
 * of keys while minimizing memory usage.
 * 1/8/2025
 */

import java.util.*;

class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int moves = 0;
        HashSet<String> visited = new HashSet<>(); // "x,y,currKeysAquired" 001000
        int keyMask = 0;

        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Deque<int[]> deque = new ArrayDeque<>();
        int startX = 0, startY = 0;

        // Go through grid, tracking the start value and figuring which keys are available.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                Character c = grid[i].charAt(j);
                if (c == '@') {
                    startX = i;
                    startY = j;
                } else if (c >= 'a' && c <= 'f')
                    keyMask = keyMask | 1 << (c - 'a');
            }
        }

        deque.add(new int[] { startX, startY, 0 });

        // Perform bfs, counting number of moves.
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] curr = deque.remove();
                int x = curr[0], y = curr[1], currKeys = curr[2];

                // Reached all keys
                if (currKeys == keyMask)
                    return moves;

                for (int[] direction : directions) {
                    int neiX = x + direction[0];
                    int neiY = y + direction[1];

                    // Out of bounds
                    if (neiX < 0 || neiY < 0 || neiX >= grid.length || neiY >= grid[neiX].length())
                        continue;

                    char neiChar = grid[neiX].charAt(neiY);
                    // Wall
                    if (neiChar == '#')
                        continue;

                    // Collect key if it's a key
                    int newKeys = currKeys;
                    if (neiChar >= 'a' && neiChar <= 'f')
                        newKeys |= (1 << neiChar - 'a');

                    // If it's a door and we don't have the key, skip
                    if (neiChar >= 'A' && neiChar <= 'F' && (newKeys & (1 << (neiChar - 'A'))) == 0)
                        continue;

                    String newState = neiX + "," + neiY + "," + newKeys;
                    if (visited.contains(newState))
                        continue;
                    deque.add(new int[] { neiX, neiY, newKeys });
                    visited.add(newState);

                }
            }
            moves++;
        }
        return -1;
    }
}

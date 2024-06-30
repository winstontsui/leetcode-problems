/*
 * Leetcode 286: Walls and Gates. Java. Medium.
 * O(n*m) runtime and O(n*m) space complexity.
 * Determine coordinates of gates and store in a deque. Do BFS to fill each empty room with the distance to its nearest gate one by one.
 * 6/30/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public void wallsAndGates(int[][] rooms) {
        Deque<int[]> gates = new ArrayDeque<>();
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for (int r = 0; r < rooms.length; r++)
            for (int c = 0; c < rooms[0].length; c++)
                if (rooms[r][c] == 0)
                    gates.add(new int[] { r, c });

        // Layered BFS
        int distance = 1;
        while (!gates.isEmpty()) {
            int size = gates.size();
            while (size-- > 0) {
                int[] gate = gates.remove();
                for (int[] direction : directions) {
                    int[] newCord = { direction[0] + gate[0], direction[1] + gate[1] };
                    // Terminate invalid coordinates
                    if (newCord[0] < 0 || newCord[1] < 0 || newCord[0] > rooms.length - 1
                            || newCord[1] > rooms[0].length - 1 || rooms[newCord[0]][newCord[1]] != Integer.MAX_VALUE)
                        continue;
                    rooms[newCord[0]][newCord[1]] = distance;
                    gates.add(newCord);
                }
            }
            distance++;
        }
    }
}

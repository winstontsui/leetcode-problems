/*
 * Leetcode 1232: Check If It Is a Straight Line. Java. Easy.
 * O(N) runtime and O(1) space complexity.
 * Uses integer cross-multiplication to compare slopes between points, avoiding floating-point precision issues.
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Step 1: Use first two points (x1,y1), (x2,y2) to define base slope.
 * Step 2: For each (xi, yi), check:
 *   (yi - y1) * (x2 - x1) == (y2 - y1) * (xi - x1)
 *
 * 5/1/2025 Winston Tsui
 */

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // Cross-multiply to avoid division: (y3 - y1) * (x2 - x1) == (y2 - y1) * (x3 - x1)
        int x1 = coordinates[0][0], y1 = coordinates[0][1];
        int x2 = coordinates[1][0], y2 = coordinates[1][1];

        for (int i = 2; i < coordinates.length; i++) {
            int xi = coordinates[i][0], yi = coordinates[i][1];
            if ((yi - y1) * (x2 - x1) != (y2 - y1) * (xi - x1)) {
                return false;
            }
        }
        return true;
    }
}

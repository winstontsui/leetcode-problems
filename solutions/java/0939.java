/*
 * Leetcode 939: Minimum Area Rectangle. Java. Medium.
 * O(n^2) runtime and O(n) space complexity, where n is the number of points.
 * The problem is solved using a HashSet to store all points for fast lookup.
 * For every pair of points, check if they can form the diagonal of a rectangle,
 * and verify if the other two diagonal points exist in the set.
 * If a rectangle is formed, calculate its area and track the minimum area found.
 * 11/17/2024 Winston Tsui
 */


import java.util.HashSet;

class Solution {
    public int minAreaRect(int[][] points) {
        int minArea = Integer.MAX_VALUE;
        HashSet<String> pointSet = new HashSet<>();
        
        // Store points in hashset
        for (int[] point : points) {
            String currPoint = point[0] + " " + point[1];
            pointSet.add(currPoint);
        }

        // If two points form a diagonal, search up the other diagonal in the set.
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], x2 = points[j][0];
                int y1 = points[i][1], y2 = points[j][1];

                // Ensure the two points are diagonal
                if (x1 == x2 || y1 == y2)
                    continue;

                // Determine if other diagonal is in set, and if it is, find its area.
                String point3 = x1 + " " + y2;
                String point4 = x2 + " " + y1;

                if (pointSet.contains(point3) && pointSet.contains(point4)) {
                    int area = Math.abs((x2 - x1) * (y2 - y1));
                    minArea = Math.min(minArea, area);
                }

            }
        }
        // If no rectangle was found, return 0
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}

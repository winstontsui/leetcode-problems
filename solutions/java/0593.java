/*
 * Leetcode 593: Valid Square. Java. Medium.
 * O(1) runtime and O(1) space complexity.
 * Uses distance calculations to check if four given points form a valid square.
 * A valid square must have exactly two unique distances: four equal side lengths and two equal diagonal lengths.
 * Use squared Euclidean distance.
 * Tricky Part: Ensuring no duplicate points and verifying that only two unique distances exist.
 * 3/11/2025 Winston Tsui
*/

import java.util.*;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // Check that all four side lengths are equal.
        // Diagonals are equal
        HashSet<Integer> distances = new HashSet<>();

        distances.add(distance(p1, p2));
        distances.add(distance(p1, p3));
        distances.add(distance(p1, p4));
        distances.add(distance(p2, p3));
        distances.add(distance(p2, p4));
        distances.add(distance(p3, p4));

        return distances.size() == 2 && !distances.contains(0);
    }

    private int distance(int[] first, int[] second) {
        return (first[0] - second[0]) * (first[0] - second[0]) + (first[1] - second[1]) * (first[1] - second[1]);
    }
}

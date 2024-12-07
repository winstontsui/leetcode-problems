/*
 * Leetcode 2337: Move Pieces to Obtain a String. Java. Medium.
 * O(n) runtime and O(1) space complexity, where n is the length of the strings.
 * Iterate through both strings using two pointers,
 * skipping underscores, and validating movement constraints for 'L' and 'R'.
 * 'L' can only move left and 'R' can only move right; invalid scenarios are returned as false.
 * 12/7/2024 Winston Tsui
 */

class Solution {
    public boolean canChange(String start, String target) {
        int i = 0;
        int j = 0;

        while (i < start.length() && j < target.length()) {
            // Skip underscores in both strings
            while (i < start.length() && start.charAt(i) == '_')
                i++;
            while (j < target.length() && target.charAt(j) == '_')
                j++;

            // If both pointers are out of bounds, we're done
            if (i == start.length() && j == target.length())
                return true;

            // If one pointer is out of bounds but not the other, it's invalid
            if (i == start.length() || j == target.length())
                return false;

            // Check for character mismatch
            if (start.charAt(i) != target.charAt(j))
                return false;

            // Check movement constraints
            if (start.charAt(i) == 'L' && i < j)
                return false;
            if (start.charAt(i) == 'R' && i > j)
                return false;

            i++;
            j++;
        }

        // Ensure any remaining characters in both strings are underscores
        while (i < start.length()) {
            if (start.charAt(i) != '_')
                return false;
            i++;
        }
        while (j < target.length()) {
            if (target.charAt(j++) != '_')
                return false;
            j++;
        }

        return true;
    }
}

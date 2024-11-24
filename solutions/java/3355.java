/*
 * Leetcode 3355: Check if Array Becomes Zero Array After Queries. Java. Medium.
 * O(n + q) runtime and O(n) space complexity, where n is the size of the array and q is the number of queries.
 * The problem is solved using a line sweep technique to efficiently track the cumulative effect of range updates.
 * Increment and decrement operations are stored in an auxiliary array, and the cumulative sum is applied 
 * to validate if each index can be reduced to zero or less.
 * 11/24/2024 Winston Tsui
 */

class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] linesweep = new int[nums.length + 1];

        // Determine where to add and subtract
        for (int[] query : queries) {
            linesweep[query[0]]++;
            linesweep[query[1] + 1]--;
        }

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += linesweep[i];
            if (total < nums[i])
                return false;
        }
        return true;
    }
}

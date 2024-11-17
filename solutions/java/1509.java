/*
 * Leetcode 1509: Minimum Difference Between Largest and Smallest Value in Three Moves. Java. Medium.
 * O(n log n) runtime and O(1) space complexity, where n is the length of the input array.
 * The problem is solved by sorting the array and considering four cases of removing three elements:
 * removing the smallest three, the largest three, or a mix of smallest and largest elements.
 * The result is the minimum difference among the four cases.
 * 11/16/2024 Winston Tsui
 */

import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);

        if (nums.length < 4)
            return 0;
        
        int n = nums.length;
        // Either remove the smallest three, largest three, smallest two and largest, or biggest two and largest.
        int case1 = nums[n-1] - nums[3];
        int case2 = nums[n-2] - nums[2];
        int case3 = nums[n-3] - nums[1];
        int case4 = nums[n-4] - nums[0];

        return Math.min(Math.min(case1, case2), Math.min(case3, case4));
    }
}

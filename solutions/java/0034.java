/*
 * Leetcode 34: Find First and Last Position of Element in Sorted Array. Java. Medium.
 * O(log n) runtime and O(1) space complexity using two binary searches.
 * The problem is solved by first finding the leftmost occurrence of the target with a binary search
 * and then performing a second binary search to find the rightmost occurrence.
 * Edge cases such as an empty array or target not present are naturally handled.
 * 12/5/2024 Winston Tsui
 */

// TODO: Redo solution with one binary search instead of two.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};

        int l = 0, r = nums.length - 1;

        // Find first target value
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target)
                r = m;
            else
                l = m + 1;
        }

        // If target is not found
        if (nums[r] != target)
            return new int[]{-1, -1};
        int start = r;

        // Find last target value
        l = r; // Start from the first occurrence of target
        r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2; // Adjust midpoint to favor the right
            if (nums[m] > target)
                r = m - 1;
            else
                l = m; // Keep moving to the right
        }

        return new int[]{start, l};
    }
}


/*
 * Leetcode 33: Search in Rotated Sorted Array. Java. Medium.
 * O(logn) runtime and O(1) space complexity.
 * Nightmarish problem. Perform binary search, keeping in mind if the middle element 
 * is part of the left or right sorted array. After that, perform binary search.
 * 6/17/2024 Winston Tsui
 */

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == target)
                return m;

            // Determines if nums is sorted up to m, inclusive.
            if (nums[m] >= nums[l]) {
                // Determines if we search left or right of m.
                if (nums[m] > target && nums[l] <= target)
                    r = m - 1;
                else
                    l = m + 1;
            } else {
                if (nums[m] < target && nums[r] >= target)
                    l = m + 1;
                else
                    r = m - 1;
            }
        }

        return -1;
    }
}

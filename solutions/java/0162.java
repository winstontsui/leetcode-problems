/*
 * Leetcode 162: Find Peak Element. Java. Medium.
 * O(log n) time complexity using binary search, and O(1) space complexity.
 * This approach finds a peak element by comparing each mid element with its neighbor:
 * - If nums[mid] > nums[mid + 1], a peak exists on the left side (including mid), so we move `r` to `m`.
 * - Otherwise, we move `l` to `m + 1` to search the right side.
 * The algorithm guarantees finding a peak due to boundary conditions and monotonic movement towards a peak.
 * 11/10/2024 Winston Tsui
 */


class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;

            if (nums[m] < nums[m + 1])
                l = m + 1; // Move towards the right where there must be a peak
            else
                r = m; // Move towards the left or stay if nums[m] is a peak
        }
        return l; // or return r, both l and r will converge to the peak
    }
}

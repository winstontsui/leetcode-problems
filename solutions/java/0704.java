/*
 * Leetcode 704: Binary Search. Java. Easy.
 * O(log(n)) runtime and O(1) space complexity.
 * Do basic binary search to find target.
 * 4/20/2024 Winston Tsui
*/

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target)
                return m;
            if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }
}

/*
 * Leetcode 153: Find Minimum in Rotated Sorted Array. Java. Medium.
 * Nasty nasty problem. O(log(n)) runtime and O(1) space complexity.
 * Use binary search to compare elements and return the min.
 * 3/19/2024 Winston Tsui
*/

class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            if (nums[l] < nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }

            // This part of the algorithm only works on a rotated sorted array. If it's not
            // a rotated sorted array, break out and return the min!
            int mid = (l + r) / 2;
            if (nums[mid] <= nums[r]) {
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            } else
                l = mid + 1; // Ex. nums=[4,5,6,7,0,1,2]. nums[mid] = 7, so look to the RIGHT.

        }
        return min;
    }
}

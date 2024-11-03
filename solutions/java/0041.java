/*
 * Leetcode 41: First Missing Positive. Java. Hard.
 * O(n) runtime and O(1) space complexity.
 * Use cyclic sort to place each number x within the range [1, n] at index x - 1.
 * After sorting, the first index i where nums[i] != i + 1 gives the smallest missing positive.
 * 11/3/2024 Winston Tsui
 */

class Solution {
    public int firstMissingPositive(int[] nums) {
        // Cyclic sort is useful here because we need to place items in their correct indicies,
        // the expected values are between 1 and nums.length+1, and we don't want to use additional space.
        // Tterate through nums, swapping elements until each number is either in its
        // correct position or out of range.

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                // Swap elements
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i + 1;

        // All the elements are correctly positioned so the smallest missing positive is
        // n+1.
        return nums.length + 1;
    }
}

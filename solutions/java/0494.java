/*
 * Leetcode 494: Target Sum. Java. Medium.
 * O(2^n) time complexity due to exploring two choices (add or subtract) for each element in nums.
 * Uses backtracking to recursively explore all possible ways to assign + and - to each number.
 * Base case checks if the target is reached after all elements are processed.
 * 11/6/2024 Winston Tsui
 */


class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, target, 0);
    }

    private int backtrack(int[] nums, int target, int index) {
        // Base case: when we've processed all numbers, have we found a valid expression that can be built?
        if (index == nums.length)
            return target == 0 ? 1 : 0;

        // Choose the current number as positive or negative, and recurse
        int add = backtrack(nums, target + nums[index], index + 1);
        int subtract = backtrack(nums, target - nums[index], index + 1);

        return add + subtract;
    }
}

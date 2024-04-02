/*
 * Leetcode 213: House Robber II. Java. Medium.
 * O(n) runtime and O(1) space complexity. 
 * The first and last house are adjacent, so we must break up nums from 0-nums.length-2 and 1-nums.length-1.
 * Return the max amount I can steal from these two subproblems.
 * 4/2/2024 Winston Tsui
*/

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int first = 0;
        int second = nums[start];
        for (int i = start + 1; i <= end; i++) {
            int currSum = Math.max(first + nums[i], second);
            first = second;
            second = currSum;
        }
        return second;
    }
}

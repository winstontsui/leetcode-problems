/*
 * LeetCode 55: Jump Game. Java. Medium.
 * O(n) time complexity as we iterate through the array once.
 * O(1) space complexity since only variable is used.
 * Uses a greedy approach to determine if the last index is reachable:
 * - Initialize `reach` to track the farthest index reachable from each position.
 * - For each index, update `reach` to the maximum distance achievable.
 * - If at any point `i > reach`, return false as it's not possible to progress further.
 * - If `reach` reaches or exceeds the last index, return true.
 * 11/12/2024 Winston Tsui
 */


class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0; // Furthest possible point we can jump to
        
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond the reach, we can't continue
            if (i > reach)
                return false;
            reach = Math.max(reach, nums[i] + i);

            // If we can reach or go beyond the last index, return true
            if (reach >= nums.length - 1)
                return true;
        }
        return false;
    }
}

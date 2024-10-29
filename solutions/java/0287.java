/*
 * Leetcode 287: Find the Duplicate Number. Java. Medium.
 * O(n) runtime. O(1) space complexity.
 * Use Floyd’s Tortoise and Hare algorithm to detect the cycle in the array
 * and find the duplicate number. User slow2 pointer to detect cycle.
 * 10/29/2024 Winston Tsui
 */

public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find the entrance to the cycle, which is the duplicate number
        int slow2 = nums[0];
        while (slow2 != slow) {
            slow2 = nums[slow2];
            slow = nums[slow];
        }

        return slow;
    }
}


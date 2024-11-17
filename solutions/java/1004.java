/*
 * Leetcode 1004: Max Consecutive Ones III. Java. Medium.
 * O(n) runtime and O(1) space complexity, where n is the length of the input array.
 * The problem is solved using a sliding window approach to find the longest subarray of 1s 
 * by allowing at most k flips of 0s to 1s. The window shrinks dynamically when the number of flips exceeds k.
 * 11/16/2024 Winston Tsui
 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxConsecutive = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0)
                k--;

            // Shrink the window if we used more than k flips
            while (k < 0) {
                if (nums[l++] == 0)
                    k++;
            }

            // Determine if this window contains the maximum number of consecutive 1s.
            maxConsecutive = Math.max(maxConsecutive, r - l + 1);
        }
        return maxConsecutive;
    }
}

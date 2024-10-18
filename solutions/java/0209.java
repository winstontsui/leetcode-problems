/*
 * Leetcode 209: Minimum Size Subarray Sum. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * Sliding window problem: Use two pointers and the min length and current window length. Update as necessary.
 * 10/18/2024 Winston Tsui
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int currLength = 0;
        int currSum = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            currLength += 1;
            currSum += nums[r];

            while (currSum >= target) {
                minLength = Math.min(minLength, currLength); //currLength is unnecessary; r-l+1 can instead be used.
                currSum -= nums[l];
                l++;
                currLength--;
            }

        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
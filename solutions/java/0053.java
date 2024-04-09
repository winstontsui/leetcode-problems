/*
 * Leetcode 53: Maximum Subarray. Java. Medium.
 * O(n) runtime and O(1) space complexity.
 * Use a variable currSum to track sum up to a certain point. At any given point,
 * if the sum is less than 0, it cannot be used in later subarrays to achieve max sum, so reset it.
 * 4/7/2024 Winston Tsui
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int num : nums) {
            currSum += num;
            maxSum = Math.max(maxSum, currSum);

            // If the sum up to this point is negative, it can't be part of future subarrays, so reset it.
            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }
}

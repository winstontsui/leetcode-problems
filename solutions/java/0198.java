/*
 * Leetcode 198: House Robber. Java. Medium.
 * O(n) runtime and O(1) space complexity. 
 * Dynamic programming problem. Use an array of length 3 to store the max amount I can steal
 * up until nums[i]. Because nums[i] > 0, the max amount at point i is nums[i-1] or nums[i] + nums[i-2].
 * Only two previous values are necessary to compute nums[i], making this O(1) space complexity.
 * 4/1/2024 Winston Tsui
*/

class Solution {
    public int rob(int[] nums) {
        int[] maxAmt = new int[3];
        for (int num : nums) {
            maxAmt[2] = Math.max(maxAmt[1], maxAmt[0] + num);
            maxAmt[0] = maxAmt[1];
            maxAmt[1] = maxAmt[2];
        }
        return maxAmt[1];

    }
}

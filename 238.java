/*
 * Leetcode 238: Product of Array Except Self. Java. Medium.
 * Bruh problem. O(n) runtime and O(1) space complexity.
 * To make this problem O(1), keep a prefix array and multiply with a 
 * postfix variable get the answer[i]. I stored the answer in prefix[].
 * 2/12/2024 Winston Tsui
*/

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];

        // Store prefix up until nums[i] in prefix[i-1].
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            prefix[i] = prefix[i - 1] * nums[i];

        int postfix = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            prefix[i] = prefix[i - 1] * postfix;
            postfix *= nums[i];
        }

        prefix[0] = postfix;
        return prefix;
    }
}

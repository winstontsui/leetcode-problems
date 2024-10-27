/*
 * Leetcode 238: Product of Array Except Self. Java. Medium.
 * Bruh problem. O(n) runtime and O(1) space complexity.
 * To make this problem O(1), keep a prefix array and multiply with a 
 * postfix variable get the answer[i]. I stored the answer in prefix[].
 * 2/12/2024 Winston Tsui
*/

class Solution {
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

// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] ans = new int[nums.length];
//         ans[0] = 1;
//         // Step 1: Calculate left products. (prefix sum of nums[i] which is up to i-1.)
//         for (int i = 1; i < nums.length; i++)
//             ans[i] = ans[i - 1] * nums[i - 1];

//         // Step 2: Calculate right products and multiply with left products
//         int rightProduct = 1;
//         for (int i = nums.length - 1; i >= 0; i--) {
//             ans[i] *= rightProduct;
//             rightProduct *= nums[i];
//         }
//         return ans;
//     }
// }

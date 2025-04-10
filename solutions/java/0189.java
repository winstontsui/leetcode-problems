/*
 * Leetcode 189: Rotate Array. Java. Medium.
 * O(N) runtime and O(1) space complexity.
 * Rotates the array to the right by `k` steps using three-step reverse technique.
 * This method avoids using extra space by reversing the entire array, then reversing segments.
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Step 1: Reverse whole array      -> [7,6,5,4,3,2,1]
 * Step 2: Reverse first k elements -> [5,6,7,4,3,2,1]
 * Step 3: Reverse remaining        -> [5,6,7,1,2,3,4]
 *
 * Output: [5,6,7,1,2,3,4]
 *
 * 4/10/2025 Winston Tsui
 */

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }

    private void reverse(int l, int r, int[] nums) {
        while (r > l) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
}

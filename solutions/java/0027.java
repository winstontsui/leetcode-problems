/*
 * Leetcode 27: Remove Element. Java. Easy.
 * O(n) runtime and O(1) space complexity, where n is the length of the input array.
 * Use the two-pointer technique. The `swapIndex` pointer
 * tracks the position where valid elements (not equal to `val`) should be placed.
 * Conditional assignments ensure unnecessary swaps are avoided for optimal performance.
 * 12/2/2024 Winston Tsui
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        int swapIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                // Perform swap if necessary.
                if (swapIndex != i)
                    nums[swapIndex] = nums[i]; // Place valid element at position swapIndex
                swapIndex++;
            }
        }
        return swapIndex;
    }
}

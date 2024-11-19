/*
 * Leetcode 26: Remove Duplicates from Sorted Array. Java. Easy.
 * O(n) runtime and O(1) space complexity, where n is the length of the array.
 * The problem is solved using the two-pointer technique. One pointer (i) tracks the position of the last unique element,
 * while the other pointer (j) iterates through the array to find new unique elements. The array is modified in-place,
 * and the function returns the new length of the modified array.
 * 11/19/2024 Winston Tsui
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0; // Pointer for the position of the last unique element

        for (int r = 1; r < nums.length; r++) {
            if (nums[l] != nums[r]) {
                l++; // Increment i to move to the next unique position
                nums[l] = nums[r]; // Update nums[i] with the new unique value
            }
        }
        return l + 1;
    }
}

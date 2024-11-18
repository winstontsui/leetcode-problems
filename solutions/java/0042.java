/*
 * Leetcode 42: Trapping Rain Water. Java. Hard.
 * O(n) runtime and O(1) space complexity, where n is the length of the height array.
 * The problem is solved using the two-pointer approach. Two pointers traverse the array from both ends, tracking
 * the maximum height seen so far on the left and right. At each step, water trapped at the current index is determined 
 * by the difference between the current height and the minimum of the left and right maximums.
 * 11/17/2024 Winston Tsui
 */

class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int waterTrapped = 0;

        while (l < r){
            if (height[l] < height[r]){
                // Update leftMax and calculate trapped water for the left pointer
                leftMax = Math.max(height[l], leftMax);
                waterTrapped += leftMax - height[l++];
            }
            else{
                // Update rightMax and calculate trapped water for the right pointer
                rightMax = Math.max(height[r], rightMax);
                waterTrapped += rightMax - height[r--];
                
            }
        }
        return waterTrapped;
    }
}

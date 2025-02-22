/*
 * Leetcode 334: Increasing Triplet Subsequence. Java. Medium.
 * O(N) runtime and O(1) space complexity.
 * Uses a greedy approach to track the smallest and second smallest elements (`first` and `second`).
 * If a third element is found that is greater than both, an increasing triplet exists.
 * Tricky Part: Properly updating `first` and `second` to maintain the correct order.
 * 2/21/2025 Winston Tsui
*/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first)
                first = num;
            else if (num <= second)
                second = num;
            else
                return true;
        }
        return false;
    }

}

/*
 * Leetcode 2971: Find Polygon With the Largest Perimeter. Java. Medium.
 * O(nlogn) runtime and O(logn) space complexity.
 * Sort nums. Working backwards, determine whether nums[0] to nums[i] is a valid polygon, returning the perimeter if it is.
 * 7/18/2024 Winston Tsui
*/

import java.util.Arrays;

class Solution {
    public long largestPerimeter(int[] nums) {
        long sum = 0;
        Arrays.sort(nums);
        for (int num : nums)
            sum += num;

        for (int i = nums.length - 1; i > 1; i--) {
            sum -= nums[i];
            if (sum > nums[i])
                return sum + nums[i];
        }
        return -1;
    }
}

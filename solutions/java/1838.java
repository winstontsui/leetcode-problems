/*
 * Leetcode 1838: Frequency of the Most Frequent Element. Java. Medium.
 * O(n) runtime and O(1) space complexity.
 * Sliding window problem. The main condition is to check if k is large enough to make all elements in the window the same.
 * Can the total of all the elements in the window plus k be enough to make all elements the same?
 * 7/2/2024 Winston Tsui
 */

import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0;
        int r = 0;
        long total = 0;
        int maxFreq = 0;

        while (r < nums.length) {
            total += nums[r];
            while ((long) (r - l + 1) * nums[r] > total + k) {
                total -= nums[l];
                l++;
            }
            if (r - l + 1 > maxFreq)
                maxFreq = r - l + 1;
            r++;
        }
        return maxFreq;
    }
}

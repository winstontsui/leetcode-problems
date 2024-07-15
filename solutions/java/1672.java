/*
 * Leetcode 1672: Richest Customer Wealth. Java. Easy.
 * O(n*m) runtime and O(n) space complexity.
 * Simple: Add and track the balance of each customer, and if its greater than the max, make it the max.
 * 7/14/2024 Winston Tsui
*/

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int curr = 0;
            for (int i : account)
                curr += i;
            if (curr > max)
                max = curr;
        }
        return max;
    }
}

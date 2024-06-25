/*
 * Leetcode 740: Delete and Earn. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * Dynamic Programming problem similar to house robber. Find the maximum number, 
 * use an array to store total points for each number and use dp to the track maximum points up to index i.
 * 6/25/2024 Winston Tsui
 */

class Solution {
    public int deleteAndEarn(int[] nums) {
        // Find max number
        int maxNum = 0;
        for (int num : nums)
            if (num > maxNum)
                maxNum = num;

        // Store total points for each number
        int[] points = new int[maxNum + 1];
        for (int num : nums)
            points[num] += num;

        // Dynamic Programming
        points[1] = Math.max(points[0], points[1]);
        for (int i = 2; i < points.length; i++)
            points[i] = Math.max(points[i - 1], points[i - 2] + points[i]);

        return points[points.length - 1];
    }
}

/*
 * Leetcode 70: Climbing Stairs. Java. Easy.
 * Refreshing DP problem. O(n) runtime and O(1) spacetime.
 * I used steps[] to count the number of steps necessary for that n.
 * steps[1] depends on the previous two steps, which are steps[1] and steps[0].
 * 2/13/2024 Winston Tsui
*/

class Solution {
    public int climbStairs(int n) {
        int[] steps = { 1, 2 };
        if (n == 1 || n == 2)
            return steps[n - 1];

        for (int i = 2; i < n; i++) {
            int temp = steps[0];
            steps[0] = steps[1];
            steps[1] += temp;
        }
        return steps[1];
    }
}
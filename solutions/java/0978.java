/*
 * Leetcode 978: Longest Turbulent Subarray. Java. Medium.
 * O(N) runtime and O(1) space complexity.
 * Have two counters: one for "up" patterns and one for "down" patterns.
 * Each time the comparison flips (greater/less), extend the current turbulent subarray.
 *
 * Input: arr = [9,4,2,10,7,8,8,1,9]
 *   → 9 > 4 → up = 1, down = 2
 *   → 4 > 2 → up = 1, down = 2
 *   → 2 < 10 → up = down+1 = 3, down = 1
 *   → 10 > 7 → down = up+1 = 4, up = 1
 *   → 7 < 8 → up = down+1 = 2, down = 1
 *   → 8 = 8 → up = down = 1
 *   → 8 > 1 → down = up+1 = 2, up = 1
 *   → 1 < 9 → up = down+1 = 3, down = 1
 * Result: maximum turbulent subarray length = 5
 *
 * 4/27/2025 Winston Tsui
 */


class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int downMax = 1;
        int upMax = 1;
        int down = 1; // length of longest turbulent subarray where arr[i-1] > arr[i].
        int up = 1; // length of longest turbulent subarray where arr[i-1] < arr[i].

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                down = up + 1;
                up = 1;
            } else if (arr[i] < arr[i - 1]) {
                up = down + 1;
                down = 1;
            } else {
                down = 1;
                up = 1;
            }
            upMax = Math.max(upMax, up);
            downMax = Math.max(downMax, down);

        }
        return Math.max(upMax, downMax);
    }
}

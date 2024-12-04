/*
 * Leetcode 69: Sqrt(x). Java. Easy.
 * O(log x) runtime and O(1) space complexity.
 * Use binary search to find the largest integer `mid` 
 * such that `mid * mid <= x`. The implementation prevents overflow by using 
 * long to handle potential issues with large values of `mid`.
 * 12/2/2024 Winston Tsui
 */

class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            long midSquared = (long) mid * mid;
            if (midSquared == x || midSquared < x && (long) (mid + 1) * (mid + 1) > x)
                return mid;
            else if (midSquared > x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}

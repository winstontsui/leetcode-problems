/*
 * Leetcode 2652: Sum Multiples. Java. Easy.
 * O(n) runtime and O(1) space complexity.
 * Go from 1 to n. If this number is a multiple of 3, 5, or 7, add it to ans.
 * 7/15/2024 Winston Tsui
*/

class Solution {
    public int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 2; i <= n; i++)
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
                ans += i;

        return ans;
    }
}

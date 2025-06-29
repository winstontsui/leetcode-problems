"""
 * Leetcode 278: First Bad Version. Python. Easy.
 * O(log N) runtime, O(1) space complexity
 * Binary search to find the first bad version while minimizing API calls.
 *
 * Example with n = 5, bad = 4:
 * l = 1, r = 5, m = 3 (not bad) -> l = 4
 * l = 4, r = 5, m = 4 (bad) -> r = 3
 * l = 4, r = 3 -> return l = 4
 *
 * 6/29/2025 Winston Tsui
"""

# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        l, r = 1, n

        while l <= r:
            m = l + (r - l) // 2 

            if isBadVersion(m):
                r = m - 1
            else:
                l = m + 1
        return l

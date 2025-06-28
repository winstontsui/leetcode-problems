"""
 * Leetcode 35: Search Insert Position. Python. Easy.
 * O(log N) runtime, O(1) space complexity
 * Binary search to find insertion position in a sorted array.
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * 6/26/2025 Winston Tsui
"""

from typing import List

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        while l <= r:
            m = (l + r) // 2
            if target == nums[m]:
                return m
            if target < nums[m]:
                r = m - 1
            else:
                l = m + 1
        return l

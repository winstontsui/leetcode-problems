"""
 * Leetcode 34: Find First and Last Position of Element in Sorted Array. Python. Medium.
 * O(log N) runtime, O(1) space complexity
 * Use two binary searches to find first and last occurrence of target.
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * 6/28/2025 Winston Tsui
"""

from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def find_first():
            l, r = 0, len(nums) - 1
            found = False

            while l <= r:
                m = l + (r - l) // 2

                if nums[m] >= target:
                    r = m - 1
                else:
                    l = m + 1
            return l if l < len(nums) and nums[l] == target else -1

        def find_second():
            l, r = 0, len(nums) - 1

            while l <= r:
                m = l + (r - l) // 2

                if nums[m] > target:
                    r = m - 1
                else:
                    l = m + 1
            return r if r >= 0 and nums[r] == target else -1

        l = find_first()
        r = find_second()

        return [l, r]

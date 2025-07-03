"""
 * Leetcode 410: Split Array Largest Sum. Python. Hard.
 * O(N * log(S)) runtime, O(1) space where S is sum of nums
 * Binary search between min possible (max element) and max possible (sum of all elements).
 *
 * Example with nums = [7,2,5,10,8], k = 2:
 * l = 10, r = 32, m = 21
 * - Subarrays: [7,2,5] and [10,8], sum = 14 and 18, max = 18 <= 21
 * - Update r = 20
 * l = 10, r = 20, m = 15
 * - Subarrays: [7,2,5] and [10,8], sum = 14 and 18, max = 18 > 15
 * - Update l = 16
 * Continue until l = 18, which is the minimal largest sum.
 *
 * 7/2/2025 Winston Tsui
"""

from typing import List

class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        r = sum(nums)
        l = max(nums)

        while l <= r:
            m = l + (r - l) // 2

            num_subarrays = 1
            curr_total = 0
            can_split = True

            for num in nums:
                curr_total += num
                if curr_total > m:
                    num_subarrays += 1
                    if num_subarrays > k:
                        can_split = False
                        break
                    curr_total = num

            if can_split:
                r = m - 1
            else:
                l = m + 1
        return l

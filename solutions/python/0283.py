"""
 * Leetcode 283: Move Zeroes. Python. Easy.
 * O(N) runtime and O(1) space complexity
 * Two-pass approach: First move non-zero elements to front, then fill rest with zeros.
 *
 * Input: nums = [0,1,0,3,12]
 * Step 1: First pass: [1,3,12,3,12] (curr=3)
 * Step 2: Second pass: [1,3,12,0,0]
 *
 * 6/20/2025 Winston Tsui
"""

from typing import List

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        curr = 0
        
        # First pass: Move all non-zero elements to the front
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[curr] = nums[i]
                curr += 1
                
        # Second pass: Fill remaining positions with zeros
        while curr < len(nums):
            nums[curr] = 0
            curr += 1

"""
 * Leetcode 238: Product of Array Except Self. Python. Medium.
 * O(N) runtime, O(1) space (excluding output array)
 * Uses prefix and suffix products to compute result in one pass.
 *
 * Example:
 * Input:  [1, 2, 3, 4]
 * Prefix: [1, 1, 2, 6]  (products of elements before each index)
 * Result: [24,12,8, 6]  (prefix[i] * suffix[i] for each i)
 *
 * 7/12/2025 Winston Tsui
"""

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # First pass: compute prefix products
        prod = 1
        output = [1] + [prod := prod * x for x in nums[:-1]]

        # Second pass: multiply with suffix products
        totalBackwards = 1
        for i in range(len(nums)-1, -1, -1):                
            output[i] *= totalBackwards
            totalBackwards *= nums[i]

        return output

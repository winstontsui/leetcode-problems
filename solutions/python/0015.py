"""
 * Leetcode 15: 3Sum. Python. Medium.
 * O(N^2) runtime and O(1) space complexity (excluding output)
 * Sort array and use three pointers to find triplets.
 * Skip duplicates to avoid duplicate triplets in the result.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Step 1: Sort array: [-4,-1,-1,0,1,2]
 * Step 2: For i=0, find pairs that sum to 4 (using two pointers)
 * Step 3: Skip duplicates, find valid triplets: [[-1,-1,2],[-1,0,1]]
 *
 * 6/19/2025 Winston Tsui
"""

from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        ans = []
        nums.sort()

        for first in range(len(nums)-2):
            # Skip duplicates for first number
            if first > 0 and nums[first] == nums[first-1]:
                continue

            second = first + 1
            third = n - 1

            while second < third:
                current_sum = nums[first] + nums[second] + nums[third]
                
                if current_sum == 0:
                    ans.append([nums[first], nums[second], nums[third]])
                    
                    # Skip duplicates for second and third numbers
                    while second < third and nums[second] == nums[second+1]:
                        second += 1
                    while second < third and nums[third] == nums[third-1]:
                        third -= 1
                        
                    second += 1
                    third -= 1
                    
                # Adjust pointers based on sum comparison
                elif current_sum < 0:
                    second += 1
                else:
                    third -= 1
                    
        return ans

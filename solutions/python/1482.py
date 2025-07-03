"""
 * Leetcode 1482: Minimum Number of Days to Make m Bouquets. Python. Medium.
 * O(N * log(max(bloomDay) - min(bloomDay))) runtime, O(1) space complexity
 * Binary search on days to find the minimum day that can make m bouquets of k adjacent flowers.
 *
 * Example: bloomDay = [1,10,3,10,2], m = 3, k = 1
 * 3 bouquets of 1 adjacent flower each
 * Step 1: Check if possible: k * m = 3 <= len(bloomDay) = 5
 * Step 2: Binary search between min(1) and max(10)
 * Step 3: Check if we can make 3 bouquets of 1 flower each by day 2
 * Result: 2 (can make 3 bouquets by day 2: [1], [2], [3])
 *
 * 7/2/2025 Winston Tsui
"""

from typing import List

class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        n = len(bloomDay)
        if k * m > n:
            return -1

        l, r = min(bloomDay), max(bloomDay)

        def canMakeMBouquets(mid: int) -> bool:
            count = 0
            currM = 0
            for num in bloomDay:
                if num <= mid:
                    count += 1
                    if count == k:
                        currM += 1
                        count = 0
                        if currM == m:
                            return True
                else:
                    count = 0
            return False

        # Binary search to find the smallest day that works
        while l <= r:
            mid = l + (r - l) // 2
            if canMakeMBouquets(mid):
                r = mid - 1
            else:
                l = mid + 1

        return l

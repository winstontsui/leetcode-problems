"""
 * Leetcode 57: Insert Interval. Python. Medium.
 * O(N) runtime, O(N) space complexity
 * One-pass approach to handle three cases: before, after, and overlap with new interval.
 *
 * Example: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Step 1: [1,3] overlaps with [2,5] -> merge to [1,5]
 * Step 2: [6,9] comes after [1,5] -> add to result
 * Result: [[1,5],[6,9]]
 *
 * 7/5/2025 Winston Tsui
"""

from typing import List

class Solution:
    def insert(
        self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        inserted = []

        for i in range(len(intervals)):
            # New interval comes before this
            if newInterval[1] < intervals[i][0]:
                inserted.append(newInterval)
                return inserted + intervals[i:]
            # New interval comes after this
            elif newInterval[0] > intervals[i][1]:
                inserted.append(intervals[i])
            # There's a merge conflict
            else:
                newInterval = [
                    min(newInterval[0], intervals[i][0]),
                    max(newInterval[1], intervals[i][1]),
                ]

        inserted.append(newInterval)

        return inserted

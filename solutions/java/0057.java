/*
 * Leetcode 57: Insert Interval. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * This solution processes the input intervals by iterating through them once, handling three cases:
 * intervals before the new interval, intervals after the new interval, and overlapping intervals.
 * It merges overlapping intervals on the fly and adds the new interval when appropriate, ensuring optimal performance.
 * Insights: The direct traversal approach leverages the sorted nature of intervals for simplicity and efficiency.
 * 12/26/2024 Winston Tsui
 */

import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // If this interval goes before newInterval
            if (intervals[i][1] < newInterval[0])
                ans.add(intervals[i]);

            // If this interval goes after newInterval
            else if (intervals[i][0] > newInterval[1]) {
                ans.add(newInterval);

                // Copy everything else into ans
                while (i < intervals.length)
                    ans.add(intervals[i++]);
                return ans.toArray(new int[ans.size()][]);
            }

            // If there is an insertion merge conflict
            else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}

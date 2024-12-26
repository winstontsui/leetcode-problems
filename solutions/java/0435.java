/*
 * Leetcode 435: Non-overlapping Intervals. Java. Medium.
 * O(n log n) runtime and O(1) space complexity.
 * This solution sorts the intervals by their start times and iterates through them to count the minimum number of intervals to remove to eliminate overlaps.
 * The algorithm greedily minimizes removals by keeping the interval with the earliest end time when overlaps occur.
 * Insights: Sorting by start time and minimizing overlap using the end time is key to achieving an optimal solution.
 * 12/26/2024 Winston Tsui
 */

import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals by their start time.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int numRemovals = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // If there is an overlap, count it
            if (prevEnd > intervals[i][0]) {
                numRemovals++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            } else {
                // If there is no overlap
                prevEnd = intervals[i][1];
            }
        }
        return numRemovals;
    }
}


/*
 * Leetcode 253: Meeting Rooms II. Java. Medium.
 * O(n log n) runtime and O(n) space complexity, where n is the number of intervals.
 * The problem is solved using a sweep line algorithm with a priority queue. Each interval is split into start and end events,
 * sorted by time, and processed to track the maximum number of overlapping meetings (active rooms needed).
 * This approach ensures efficient processing of intervals in chronological order.
 * 11/17/2024 Winston Tsui
 */

import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int maxRequired = 0;
        int count = 0;

        // Create a heap of events, sorting by time and breaking ties by removing the meeting that is finishing.
        PriorityQueue<int[]> events = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int[] interval : intervals){
            events.add(new int[]{interval[0], 1});
            events.add(new int[]{interval[1], -1});
        }

        while (!events.isEmpty()){
            count += events.remove()[1];
            maxRequired = Math.max(maxRequired, count);
        }

        return maxRequired;
        
    }
}

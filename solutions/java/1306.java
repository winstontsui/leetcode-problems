/*
 * Leetcode 1306: Jump Game III. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * Uses Breadth-First Search (BFS) to explore indices starting from the given index.
 * Tracks visited indices to avoid revisiting and explores valid left and right jumps 
 * iteratively. Efficiently determines whether a zero can be reached.
 * Insights: The BFS approach ensures all reachable indices are explored in linear time.
 * 1/5/2025 Winston Tsui
 */

import java.util.*;

class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        while (!deque.isEmpty()){
            int curr = deque.remove(); // curr index

            if (arr[curr] == 0)
                return true;

            if (visited[curr])
                continue;
            visited[curr] = true;

            // Explore both neighbors
            int leftNeighbor = curr - arr[curr];
            if (leftNeighbor >= 0 && !visited[leftNeighbor])
                deque.add(leftNeighbor);

            int rightNeighbor = curr + arr[curr];
            if (rightNeighbor < arr.length && !visited[rightNeighbor])
                deque.add(rightNeighbor);
        }
        return false;
    }
}

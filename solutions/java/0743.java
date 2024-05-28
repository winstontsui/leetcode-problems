/*
 * Leetcode 743: Network Delay Time. Java. Medium.
 * O((V+E)logV) runtime and O(E+V) space complexity.
 * Dijkstra's Algorithm. Build graph using adjacency list and use PriorityQueue to track travel time to nodes.
 * 5/27/2024 Winston Tsui
*/

// Dijkstra's algorithm
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<Integer[]>> map = new HashMap<Integer, List<Integer[]>>();

        // Stores a node and total time to reach it from k.
        Queue<Integer[]> pqueue = new PriorityQueue<Integer[]>((a, b) -> a[1] - b[1]);
        pqueue.add(new Integer[] { k, 0 });
        HashSet<Integer> visited = new HashSet<Integer>();
        int minTime = 0;

        // Create Adjacency List of nodes to [neighbors, time].
        for (int[] time : times) {
            if (!map.containsKey(time[0]))
                map.put(time[0], new ArrayList<>());
            map.get(time[0]).add(new Integer[] { time[1], time[2] });
        }

        while (!pqueue.isEmpty()) {
            Integer[] node = pqueue.remove();
            if (visited.contains(node[0]))
                continue;
            visited.add(node[0]);
            minTime = Math.max(minTime, node[1]);

            // Add neighbors
            if (map.containsKey(node[0]))
                for (Integer[] neighbors : map.get(node[0]))
                    if (!visited.contains(neighbors[0]))
                        pqueue.add(new Integer[] { neighbors[0], neighbors[1] + node[1] });
        }

        return (visited.size() == n) ? minTime : -1;

    }
}

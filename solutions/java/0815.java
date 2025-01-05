/*
 * Leetcode 815: Bus Routes. Java. Hard.
 * O(N + E) runtime complexity, where N is the total number of bus stops, and E is the total number of routes.
 * O(N + E) space complexity for storing the adjacency map and visited sets.
 * This solution uses Breadth-First Search (BFS) to find the shortest path (in terms of buses taken) from the source stop to the target stop.
 * Insights: The key is to map each bus stop to its corresponding bus routes for efficient traversal. A visited set for routes ensures no redundant processing.
 * 12/29/2024 Winston Tsui
 */

import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // Given a stop, which bus(es) stops at it?
        // routes = [[1,2,7],[3,6,7]]
        /*
         * 1: [0]
         * 2: [0]
         * 7: [0, 1]
         * 3: [1]
         * 6: [1]
         */
        if (source == target)
            return 0;

        int busesTaken = 0;

        // Map to associate each bus stop with the list of routes (buses) that pass through it.
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int route : routes[i]) {
                map.putIfAbsent(route, new ArrayList<>());
                map.get(route).add(i);
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> visitedRoutes = new HashSet<>();
        HashSet<Integer> visitedBusStops = new HashSet<>();

        // Add the starting stop to the queue
        deque.add(source);
        visitedBusStops.add(source);

        while (!deque.isEmpty()) {
            int size = deque.size();
            busesTaken++;

            while (size-- > 0) {
                int currStop = deque.remove();
                // Check all routes passing through the current stop
                for (int route : map.getOrDefault(currStop, new ArrayList<>())) {

                    if (!visitedRoutes.contains(route)) {
                        // Add all stops in this route to the queue
                        for (int nextStop : routes[route]) {
                            if (nextStop == target)
                                return busesTaken;
                            if (!visitedBusStops.contains(nextStop)) {
                                deque.add(nextStop);
                                visitedBusStops.add(nextStop);
                            }
                        }
                        visitedRoutes.add(currStop);
                    }
                }
            }
        }
        return -1;
    }
}



import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();

        // Use a Priority Queue (Min-Heap) to always process the least-cost path first
        Queue<int[]> heap = new PriorityQueue<>((a, b)-> a[1] - b[1]);
        heap.add(new int[] { src, 0, 0 }); // city, sum, numNodes

        // Array to track the minimum stops needed to reach each city
        int[] stopsToCity = new int[n];
        Arrays.fill(stopsToCity, Integer.MAX_VALUE);

        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new ArrayList<>());
            map.get(flight[0]).add(new int[] { flight[1], flight[2] }); // city, cost
        }

        // Dijkstra's algorithm with stops constraint
        while (!heap.isEmpty()) {
            int[] curr = heap.remove();
            int city = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            // If we reach the destination, return the cost
            if (city == dst) return cost;

            // If we exceed the allowed stops, skip this path
            if (stops > k) continue;

            // Pruning: If we’ve already reached this city with fewer stops, skip
            if (stops >= stopsToCity[city]) continue;
            stopsToCity[city] = stops;

            // Ensure city has outgoing flights
            if (map.containsKey(city)) {
                for (int[] neighbor : map.get(city)) {
                    int newCity = neighbor[0];
                    int newCost = neighbor[1] + cost;

                    // Add the new state to the priority queue
                    heap.add(new int[] {newCity, newCost, stops + 1});
                }
            }
        }

        return -1; // If we cannot reach the destination within k stops
    }
}

/*
 * Leetcode 1928: Minimum Cost to Reach Destination in Time. Java. Hard.
 * O(E * T) runtime and O(V * T) space complexity.
 * Uses a combination of Dijkstra's algorithm and a 2D DP array to find the minimum cost path to reach the destination node within the given time constraint.
 * The priority queue processes paths in increasing order of cost, while the DP array ensures redundant or suboptimal paths are avoided.
 * Insights: The algorithm efficiently prunes paths exceeding the time limit and guarantees the minimum cost using a greedy approach.
 * 12/23/2024 Winston Tsui
 */

import java.util.*;

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {

        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>(); // Stores [node, [neighborNode1, time]]

        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(new int[] { edge[1], edge[2] });
            map.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }

        // DP array: minCost[node][time] tracks the minimum cost to reach a node within
        // a given time
        int[][] minCost = new int[passingFees.length][maxTime + 1];
        for (int[] row : minCost)
            Arrays.fill(row, Integer.MAX_VALUE);

        minCost[0][0] = passingFees[0];

        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]); // [node, distance, cost]
        heap.add(new int[] { 0, 0, passingFees[0] });

        while (!heap.isEmpty()) {
            int[] curr = heap.remove();
            int currNode = curr[0];
            int time = curr[1];
            int cost = curr[2];

            if (currNode == passingFees.length - 1)
                return cost;

            for (int[] neighbor : map.get(currNode)) {
                int newNode = neighbor[0];
                int newTime = time + neighbor[1];
                int newCost = cost + passingFees[newNode];

                // If within time and offers a lower cost, update and push to the queue
                if (newTime <= maxTime && newCost < minCost[newNode][newTime]) {
                    heap.add(new int[] { newNode, newTime, newCost });
                    minCost[newNode][newTime] = newCost;
                }
            }
        }
        return -1;
    }
}

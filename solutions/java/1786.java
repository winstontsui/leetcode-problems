/*
 * Leetcode 1786: Number of Restricted Paths From First to Last Node. Java. Medium.
 * O((n + e) * log n) runtime and O(n + e) space complexity.
 * Uses Dijkstra's algorithm to calculate shortest distances from the last node to all nodes.
 * DFS with memoization is then used to count restricted paths, defined as paths where 
 * each subsequent node has a shorter distance to the last node.
 * Insights: This approach combines shortest-path algorithms with recursive path counting.
 * 1/7/2025
 */

import java.util.*;

class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        // Graph representation
        HashMap<Integer, List<int[]>> connections = new HashMap<>();
        for (int[] edge : edges) {
            connections.putIfAbsent(edge[0], new ArrayList<>());
            connections.putIfAbsent(edge[1], new ArrayList<>());
            connections.get(edge[0]).add(new int[] { edge[1], edge[2] });
            connections.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }

        // Step 1: Dijkstra's algorithm to compute shortest distances
        int[] shortestPath = new int[n + 1];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        dijkstra(n, shortestPath, connections);

        // Step 2: DFS with memoization to count restricted paths
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(1, n, shortestPath, connections, memo);
    }

    private void dijkstra(int n, int[] shortestPath, HashMap<Integer, List<int[]>> connections) {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> (a[1] - b[1])); // [node, distance]
        heap.add(new int[] { n, 0 });
        shortestPath[n] = 0;

        while (!heap.isEmpty()) {
            int[] curr = heap.remove();
            int currNode = curr[0];
            int currDist = curr[1];

            if (currDist > shortestPath[currNode])
                continue;

            for (int[] neighbor : connections.get(currNode)) {
                int neiNode = neighbor[0];
                int neiDist = currDist + neighbor[1];
                if (neiDist < shortestPath[neiNode]) {
                    shortestPath[neiNode] = neiDist;
                    heap.add(new int[] { neiNode, neiDist });
                }
            }
        }
    }

    private int dfs(int node, int n, int[] shortestPath, HashMap<Integer, List<int[]>> connections, int[] memo) {
        if (node == n)
            return 1;
        if (memo[node] != -1)
            return memo[node]; // Return cached result

        int MOD = 1_000_000_007;

        int numPaths = 0;
        for (int[] neighbor : connections.get(node)) {
            if (shortestPath[neighbor[0]] != Integer.MAX_VALUE && shortestPath[node] != Integer.MAX_VALUE
                    && shortestPath[neighbor[0]] < shortestPath[node]) {
                numPaths = (numPaths + dfs(neighbor[0], n, shortestPath, connections, memo)) % MOD;
            }
        }

        memo[node] = numPaths;
        return numPaths;
    }
}

/*
 * Leetcode 323: Number of Connected Components in an Undirected Graph. Java. Medium.
 * O(E + V) runtime and O(E + V) space complexity.
 * Construct a HashMap of neighboring nodes and use DFS to count how many connected components there are in edges.
 * Use a HashSet to prevent components from being recounted.
 * 3/9/2024 Winston Tsui
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int countComponents(int n, int[][] edges) {
        int numComponents = 0;
        HashMap<Integer, ArrayList<Integer>> neighbors = new HashMap<Integer, ArrayList<Integer>>();

        // Construct list of neighbors for all nodes.
        for (int i = 0; i < n; i++)
            neighbors.put(i, new ArrayList<Integer>() {});
        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> seen = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (!seen.contains(i)) {
                dfs(i, neighbors, seen);
                numComponents += 1;
            }
        }
        return numComponents;

    }

    // Prevents neighboring/connected nodes from being recounted through seen HashSet.
    private void dfs(Integer node, HashMap<Integer, ArrayList<Integer>> neighbors, HashSet<Integer> seen) {
        if (seen.contains(node))
            return;
        seen.add(node);

        for (int neighbor : neighbors.get(node))
            dfs(neighbor, neighbors, seen);
    }
}

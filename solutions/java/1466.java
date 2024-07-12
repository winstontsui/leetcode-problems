/*
 * Leetcode 1466: Reorder Routes to Make All Paths Lead to the City Zero. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * Horrifying problem. Create a graph of all neighbors and another of just the directed neighbors. 
 * Perform DFS starting from node 0 on its neighbors, adding 1 to count if there is no directed edge from its neighbor towards itself.
 * 7/12/2024 Winston Tsui
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    int ans = 0;

    public int minReorder(int n, int[][] connections) {
        HashSet<Integer> visited = new HashSet<>();
        // There can be multiple directed edges for each node, so a HashMap storing one edge for each node doesn't work.
        HashSet<String> directedNeighbors = new HashSet<>(); 
        for (int[] connection : connections)
            directedNeighbors.add(connection[0] + " -> " + connection[1]);

        // Build neighbors graph for adjacent nodes.
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] connection : connections) {
            if (!graph.containsKey(connection[0]))
                graph.put(connection[0], new ArrayList<>());
            if (!graph.containsKey(connection[1]))
                graph.put(connection[1], new ArrayList<>());
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }

        visited.add(0);
        dfs(0, graph, directedNeighbors, visited);
        return ans;

    }

    private void dfs(Integer node, HashMap<Integer, List<Integer>> graph, HashSet<String> directedNeighbors, HashSet<Integer> visited) {
        for (Integer currNode : graph.get(node)) {
            if (visited.contains(currNode))
                continue;
            if (!directedNeighbors.contains(currNode + " -> " + node))
                ans++;
            visited.add(currNode);
            dfs(currNode, graph, directedNeighbors, visited);

        }
    }

}

/*
 * Leetcode 802: Find Eventual Safe States. Java. Medium.
 * O(V + E) runtime and O(V + E) space complexity.
 * Uses graph traversal to identify safe nodes that do not lead to cycles.
 * DFS Approach: Detect cycles and mark nodes that only lead to terminal states.
 * 2/26/2025 Winston Tsui
*/

import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, map, i))
                safeNodes.add(i);
        }
        return safeNodes;
    }

    private boolean dfs(int[][] graph, HashMap<Integer, Boolean> map, int i) {
        if (map.get(i) != null)
            return map.get(i);

        // Assume it's not a safe node at first. If later we determine i is safe, update map.
        map.put(i, false);
        for (int neighbor : graph[i]) {
            if (!dfs(graph, map, neighbor))
                return false;
        }

        // ALL of the neighbors have to be terminal nodes in order for this node to be safe.
        map.put(i, true);
        return true;
    }
}

/*
 * Leetcode 210: Course Schedule II. Java. Medium.
 * O(V + E) runtime and O(V + E) space complexity.
 * Implements a directed graph using an adjacency list to represent course dependencies.
 * Uses Depth-First Search (DFS) to perform topological sorting while detecting cycles.
 * Key Insight: If a cycle is detected during DFS traversal, return an empty array (no valid order exists).
 * Tricky Part: Maintaining `visited` and `onPath` sets to differentiate between fully processed nodes and active DFS paths.
 * 2/22/2025 Winston Tsui
*/

import java.util.*;

class Solution {
    List<Integer> ans = new ArrayList<>();
    Set<Integer> onPath = new HashSet<>();
    Set<Integer> visited = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
         * numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
         * prereqMap = {0: [],
         * 1: [0],
         * 2: [0],
         * 3: [1, 2]}
         */
        Map<Integer, ArrayList<Integer>> prereqMap = new HashMap<>();

        // Graph construction
        for (int i = 0; i < numCourses; i++)
            prereqMap.put(i, new ArrayList<>());

        for (int[] prereq : prerequisites)
            prereqMap.get(prereq[0]).add(prereq[1]);

        // Topological sort
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i))
                if (!dfs(i, prereqMap))
                    return new int[] {};
        }
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            answer[i] = ans.get(i);

        return answer;

    }

    private boolean dfs(int i, Map<Integer, ArrayList<Integer>> prereqMap) {
        visited.add(i);
        onPath.add(i);

        for (int neighbor : prereqMap.get(i)) {
            if (!visited.contains(neighbor)) {
                if (!dfs(neighbor, prereqMap))
                    return false;
            } else {
                // If neighbor is in the current DFS path, there's a cycle
                if (onPath.contains(neighbor))
                    return false;
            }
        }
        onPath.remove(i);
        ans.add(i);
        return true;
    }
}

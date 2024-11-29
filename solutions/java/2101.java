/*
 * Leetcode 2101: Detonating the Maximum Bombs. Java. Medium.
 * O(n^2) runtime and O(n^2) space complexity, where n is the number of bombs.
 * Create a directed graph, where an edge from bomb i to bomb j
 * exists if bomb i's range includes bomb j. Depth-first search (DFS) is performed from each bomb
 * to determine the maximum number of bombs that can be detonated starting from that bomb.
 * The solution efficiently uses squared distances to avoid floating-point calculations.
 * 11/29/2024 Winston Tsui
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maximumDetonation(int[][] bombs) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < bombs.length; i++)
            graph.add(new ArrayList<>());
        

        for (int i = 0; i < bombs.length; i++){
            for (int j = 0; j < bombs.length; j++){
                if (i != j){
                    if (Math.pow(bombs[i][0] - bombs[j][0], 2) + Math.pow(bombs[i][1] - bombs[j][1], 2) <= Math.pow(bombs[i][2], 2))
                        graph.get(i).add(j);
                }
            }
        }

        // Perform DFS on graph
        int maxDetonation = 0;
        for (int i = 0; i < bombs.length; i++)
            maxDetonation = Math.max(maxDetonation, dfs(i, graph, new boolean[bombs.length]));
        
        return maxDetonation;

    }

    private int dfs(int curr, List<List<Integer>> graph, boolean[] visited) {
        visited[curr] = true; // Mark current node as visited

        int count = 1;
        for (Integer neighbor : graph.get(curr)) 
            if (!visited[neighbor])
                count += dfs(neighbor, graph, visited);
        

        return count;
    }
}

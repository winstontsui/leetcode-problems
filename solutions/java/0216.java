/*
 * Leetcode 216: Graph Valid Tree. Java. Medium.
 * Challenging Graph Problem. O(E + V) runtime and O(E + V) space complexity.
 * A tree is a special undirected graph that has no cycle and whose every node is connected.
 * Use dfs to check for cycles and put all nodes in a HashSet. Check at the end that
 * all n nodes have been traversed.
 * 3/12/2024 Winston Tsui
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> neighbors = new HashMap<Integer, ArrayList<Integer>>();
        HashSet<Integer> seen = new HashSet<Integer>();

        for (int i = 0; i < n; i++)
            neighbors.put(i, new ArrayList<Integer>() {
            });

        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        seen.add(0);

        return dfs(-1, 0, neighbors, seen) && seen.size() == n;

    }

    private boolean dfs(int prev, int node, HashMap<Integer, ArrayList<Integer>> neighbors, HashSet<Integer> seen) {
        for (int neighbor : neighbors.get(node)) {
            if (seen.contains(neighbor) && neighbor != prev)
                return false;

            if (!seen.contains(neighbor)) {
                seen.add(neighbor);
                if (!dfs(node, neighbor, neighbors, seen))
                    return false;
            }
        }
        return true;

    }
}

/*
 * Leetcode 399: Evaluate Division. Java. Medium.
 * O(N + Q * V) runtime and O(N) space complexity.
 * Constructs a directed graph where nodes represent variables and edges represent division relationships.
 * Uses Breadth-First Search (BFS) to find the shortest path between variables and compute the division result.
 * 1/25/2025 Winston Tsui
*/

import java.util.*;

class Solution {
    static class Node {
        String str;
        double weight;

        public Node(String str, double weight) {
            this.str = str;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Construct graph
        HashMap<String, HashSet<Node>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            if (!graph.containsKey(from))
                graph.put(from, new HashSet<>());
            if (!graph.containsKey(to))
                graph.put(to, new HashSet<>());
            graph.get(from).add(new Node(to, values[i]));
            graph.get(to).add(new Node(from, 1 / values[i]));
        }

        // Perform bfs starting from query[0] to query[1].
        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            if (!graph.containsKey(from) || !graph.containsKey(to)) {
                ans[i] = -1;
                continue;
            }
            if (from.equals(to)) {
                ans[i] = 1;
                continue;
            }
            ans[i] = bfs(graph, from, to);
        }

        return ans;
    }

    private double bfs(HashMap<String, HashSet<Node>> graph, String from, String to) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(from, 1));
        HashSet<String> visited = new HashSet<>();
        visited.add(from);

        while (!queue.isEmpty()) {
            Node curr = queue.remove();

            for (Node neighbor : graph.get(curr.str)) {
                if (!visited.contains(neighbor.str)) {
                    double newWeight = curr.weight * neighbor.weight;

                    if (neighbor.str.equals(to))
                        return newWeight;

                    queue.add(new Node(neighbor.str, newWeight));
                    visited.add(neighbor.str);

                }
            }
        }
        return -1;
    }
}

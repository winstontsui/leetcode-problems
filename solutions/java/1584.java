/*
 * Leetcode 1584: Min Cost to Connect All Points. Java. Medium.
 * O(N² log N) runtime and O(N^2) space complexity.
 * Uses Prim's Minimum Spanning Tree (MST) algorithm with a priority queue (Min-Heap).
 * Constructs a fully connected graph where edge weights are the Manhattan distances between points.
 * Key Insight: Instead of explicitly storing edges, a priority queue efficiently selects the minimum-cost edges.
 * 2/23/2025 Winston Tsui
*/

class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>(); // [node, [neiDist, neiNode]]

        // 1. Construct Graph
        for (int i = 0; i < points.length; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
            for (int j = i + 1; j < points.length; j++) {
                graph.putIfAbsent(j, new ArrayList<>());
                int neiDist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph.get(i).add(new int[] { neiDist, j });
                graph.get(j).add(new int[] { neiDist, i });
            }
        }

        // 2. Prim's algorithm
        int minCost = 0;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [dist, node] but I don't know to which
                                                                              // current node?
        pq.add(new int[] { 0, 0 });
        while (visited.size() < points.length) {
            int[] curr = pq.remove();
            int currDist = curr[0];
            int currNode = curr[1];

            if (visited.contains(currNode))
                continue;
            visited.add(currNode);
            minCost += currDist;

            // Explore neighbors
            for (int[] neighbor : graph.get(currNode)) {
                int neiDist = neighbor[0];
                int neiNode = neighbor[1];

                if (!visited.contains(neiNode))
                    pq.add(new int[] { neiDist, neiNode });

            }

        }
        return minCost;

    }
}


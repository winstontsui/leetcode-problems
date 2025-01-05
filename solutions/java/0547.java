/*
 * Leetcode 547: Number of Provinces. Java. Medium.
 * O(n^2) runtime and O(n) space for the queue and visited set.
 * Uses BFS to count connected components (provinces) in an adjacency matrix.
 * A deque handles traversal, and a HashSet tracks visited nodes.
 * Insights: Each BFS traversal finds one province, making it efficient for dense graphs.
 * 1/5/2025 Winston Tsui
 */

import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int numProvinces = 0;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> deque = new ArrayDeque<Integer>();

        for (int i = 0; i < isConnected[0].length; i++) {
            if (!visited.contains(i)) {
                numProvinces++;
                deque.add(i);
                while (!deque.isEmpty()) {
                    int[] currNode = isConnected[deque.remove()];
                    for (int k = 0; k < currNode.length; k++) {
                        if (!visited.contains(k) && currNode[k] == 1) {
                            deque.add(k);
                            visited.add(k);
                        }
                    }

                }
                visited.add(i);
            }
        }
        return numProvinces;
    }
}

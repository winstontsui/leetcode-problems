/*
 * Leetcode 133: Clone Graph. Java. Medium.
 * O(E + V) runtime and O(E + V) spacetime.
 * BFS problem using a HashMap to keep track of newly cloned nodes 
 * and a neighbors ArrayDeque to keep track of neighbors.
 * 2/17/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.HashMap;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        // Map of each node to its new clone.
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Queue<Node> neighbors = new ArrayDeque<Node>();
        neighbors.add(node);
        map.put(node, new Node(node.val));

        while (!neighbors.isEmpty()) {
            Node oldNode = neighbors.remove();

            for (Node neighbor : oldNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    neighbors.add(neighbor);
                }

                // In cloned node, connect neighboring cloned nodes. It's in the hashmap!
                map.get(oldNode).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);

    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

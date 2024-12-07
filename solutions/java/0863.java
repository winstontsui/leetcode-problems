/*
 * Leetcode 863: All Nodes Distance K in Binary Tree. Java. Medium.
 * O(n) runtime and O(n) space complexity, where n is the number of nodes in the tree.
 * Convert binary tree into an undirected graph, perform BFS starting from the target node 
 * to get all nodes at distance k.
 * 12/7/2024 Winston Tsui
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, graph);

        List<Integer> ans = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        // Perform bfs in a layered manner from target node to k.
        Deque<TreeNode> deque = new ArrayDeque<>();
        visited.add(target);
        deque.add(target);

        while (!deque.isEmpty()) {
            if (k == 0) {
                while (!deque.isEmpty())
                    ans.add(deque.pop().val);
                return ans;
            }

            int currSize = deque.size();
            while (currSize > 0) {
                TreeNode curr = deque.remove();
                for (TreeNode neighbor : graph.get(curr)) {
                    if (!visited.contains(neighbor)) {
                        deque.add(neighbor);
                        visited.add(neighbor);
                    }
                }
                currSize--;
            }

            k--;
        }
        return ans;

    }

    private void buildGraph(TreeNode root, HashMap<TreeNode, List<TreeNode>> graph) {
        if (root == null)
            return;

        graph.putIfAbsent(root, new ArrayList<>());

        if (root.left != null) {
            graph.putIfAbsent(root.left, new ArrayList<>());
            graph.get(root).add(root.left);
            graph.get(root.left).add(root);
            buildGraph(root.left, graph);
        }
        if (root.right != null) {
            graph.putIfAbsent(root.right, new ArrayList<>());
            graph.get(root).add(root.right);
            graph.get(root.right).add(root);
            buildGraph(root.right, graph);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

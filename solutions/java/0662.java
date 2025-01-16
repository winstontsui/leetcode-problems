/*
 * Leetcode 662: Maximum Width of Binary Tree. Java. Medium.
 * O(n) runtime and O(w) space complexity, where w is the maximum width of the tree.
 * Uses BFS with a deque to calculate the width of each level based on the positions of nodes in a "heap-like" indexing system.
 * The left and right children of a node at position `i` are positioned at `2*i + 1` and `2*i + 2`, respectively.
 * Insights: Maintains the positions of nodes to accurately measure the width, even in trees with missing nodes.
 * 1/16/2025 Winston Tsui
 */

import java.util.*;

class Solution {
    static class Pair {
        TreeNode node;
        int position;

        public Pair(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> deque = new ArrayDeque<>(); // [node, position]
        deque.add(new Pair(root, 0));
        int maxWidth = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            int l = deque.peek().position;
            int r = deque.peekLast().position;

            for (int i = 0; i < size; i++) {
                Pair curr = deque.remove();
                TreeNode node = curr.node;
                int position = curr.position;

                if (node.left != null)
                    deque.add(new Pair(node.left, position * 2 + 1));

                if (node.right != null)
                    deque.add(new Pair(node.right, position * 2 + 2));
            }
            maxWidth = Math.max(maxWidth, r - l + 1);
        }
        return maxWidth;
    }
}

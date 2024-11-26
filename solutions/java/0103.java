/*
 * Leetcode 103: Binary Tree Zigzag Level Order Traversal. Java. Medium.
 * O(n) runtime and O(w) space complexity, where n is the number of nodes in the tree and w is the maximum width of the tree.
 * The problem is solved using a queue for level-order traversal and a deque for alternating between left-to-right
 * and right-to-left traversal at each level. Each level's nodes are processed in the order required and added to the result.
 * 11/26/2024 Winston Tsui
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> zigzagTraversal = new ArrayList<>();
        deque.add(root);
        boolean leftToRight = true;

        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayList<Integer> currLevel = new ArrayList<>();

            while (size-- > 0) {
                TreeNode curr = deque.remove();
                if (leftToRight)
                    currLevel.add(curr.val);
                else
                    currLevel.add(0, curr.val);

                // Add children of curr to deque.
                if (curr.left != null)
                    deque.add(curr.left);
                if (curr.right != null)
                    deque.add(curr.right);
            }
            zigzagTraversal.add(currLevel);
            leftToRight = !leftToRight; // Toggle the direction
        }

        return zigzagTraversal;

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

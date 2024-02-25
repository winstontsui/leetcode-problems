/*
 * Leetcode 102: Binary Tree Level Order Traversal. Java. Medium.
 * Breadth-first search traversal approach. O(n) runtime and O(n) space complexity.
 * Performs a level order traversal of a tree. BFS algorithm using
 * neighbors to keep track of nodes. For each layer, use neighbors.size().
 * Retrieve neighbors and add to final ArrayList.
 * 2/25/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Arrays.asList();

        List<List<Integer>> levelsTraversal = new ArrayList<>();
        Queue<TreeNode> neighbors = new ArrayDeque<TreeNode>();
        neighbors.add(root);

        while (!neighbors.isEmpty()) {
            int currentLevelSize = neighbors.size();
            ArrayList<Integer> currLevelNumbers = new ArrayList<Integer>();

            // This performs a layered traversal of the tree.
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currNode = neighbors.remove();
                currLevelNumbers.add(currNode.val);

                // Add "neighbors" of currNode to queue, which are the left and right children.
                if (currNode.left != null)
                    neighbors.add(currNode.left);
                if (currNode.right != null)
                    neighbors.add(currNode.right);
            }

            // Add this level's values as an ArrayList to the final answer.
            levelsTraversal.add(currLevelNumbers);
        }

        return levelsTraversal;
    }
}

// Definition for a binary tree node.
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

/*
 * Leetcode 1448: Count Good Nodes in Binary Tree. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * Recursive depth-first search traversal keeping track of the minimum allowable value, 
 * used to count the number of good nodes in the tree.
 * 5/3/2024 Winston Tsui
*/

class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode root, int min) {
        if (root == null)
            return 0;
        if (root.val < min)
            return goodNodes(root.left, Math.max(root.val, min)) + goodNodes(root.right, Math.max(root.val, min));
        return 1 + goodNodes(root.left, Math.max(root.val, min)) + goodNodes(root.right, Math.max(root.val, min));
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

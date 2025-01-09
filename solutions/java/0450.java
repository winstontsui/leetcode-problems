/*
 * Leetcode 450: Delete Node in a BST. Java. Medium.
 * O(h) runtime and O(h) space complexity, where h is the height of the tree.
 * Deletes a node from a Binary Search Tree while maintaining its properties. Handles
 * three cases: no children, one child, and two children. In the case of two children,
 * the node is replaced with its in-order successor (smallest value in the right subtree),
 * and the successor is deleted recursively.
 * Insights: Recursion simplifies traversal and deletion. The in-order successor is found
 * using a loop to avoid extra recursion.
 * 1/8/2025
 */

 class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else{
            // No children
            if (root.left == null && root.right == null)
                return null;

            // 1 child
            if (root.left == null && root.right != null)
                return root.right;
            if (root.left != null && root.right == null)
                return root.left;

            // 2 children: Get smallest greater value, replace with root, then delete the leaf.
            TreeNode smallestGreater = root.right;
            while (smallestGreater.left != null)
                smallestGreater = smallestGreater.left;

            root.val = smallestGreater.val;
            root.right = deleteNode(root.right, smallestGreater.val);
        }
        return root;
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

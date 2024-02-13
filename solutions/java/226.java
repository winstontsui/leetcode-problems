/*
 * Leetcode 226: Invert Binary Tree. Java. Easy.
 * Interesting recursive problem. O(n) runtime and O(n) space complexity.
 * Recursively reverse the two children of the root by swapping them.
 * 2/10/2024 Winston Tsui
*/

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
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

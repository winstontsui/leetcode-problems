/*
 * Leetcode 235: Lowest Common Ancestor of a Binary Search Tree. Java. Medium.
 * Tough problem. O(n) runtime and O(n) space complexity.
 * Use depth-first search to recursively find depth of each branch. Update a global 
 * variable largest to find the largest diameter of the tree.
 * 4/4/2024 Winston Tsui
*/

class Solution {
    private int largest = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return largest;
    }

    private int longestPath(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = longestPath(root.left);
        int rightDepth = longestPath(root.right);
        largest = Math.max(largest, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
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

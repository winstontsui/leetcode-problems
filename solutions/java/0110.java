/*
 * Leetcode 110: Balanced Binary Tree. Java. Easy.
 * O(n) runtime and O(n) space complexity. 
 * Recursive dfs solution computing the depth of each node in root and updating a class variable 
 * result as true or false. Note that a height-balanced binary tree is a binary tree in which the depth of 
 * the two subtrees of every node never differs by more than one.
 * 3/28/2024 Winston Tsui
*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return result;
    }
    
    private boolean result = true;

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1)
            result = false;

        return 1 + Math.max(leftDepth, rightDepth);
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

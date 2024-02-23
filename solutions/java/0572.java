/*
 * Leetcode 572: Subtree of Another Tree. Java. Easy.
 * Recursive problem. O(m*n) runtime and O(h) space complexity, where m is # nodes in root, n is # nodes in subRoot.
 * Check to see if root is there, if it is, check if root and subRoot are the same tree. 
 * If they are not the same tree at root, check both of root's children recursively.
 * 2/23/2024 Winston Tsui
*/

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;

        if (isSameTree(root, subRoot))
            return true;

        // I want to check BOTH children of root to see if subRoot is that same tree.
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Leetcode problem 100
    private boolean isSameTree(TreeNode first, TreeNode second) {
        if (first == null || second == null)
            return first == second;

        return first.val == second.val && isSameTree(first.left, second.left) && isSameTree(first.right, second.right);
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

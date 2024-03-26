/*
 * Leetcode 101: Symmetric Tree. Java. Easy.
 * O(n) runtime and O(n) space complexity. 
 * Recursive solution. At a given point, compare this tree against itself. 
 * Do the roots equal and does the left subtree equal the right subtree?
 * 
 * 3/26/2024 Winston Tsui
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;

        return isSymmetric(left.left, right.right) && isSymmetric(right.left, left.right);
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

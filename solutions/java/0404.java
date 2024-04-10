/*
 * Leetcode 404: Sum of Left Leaves. Java. Easy.
 * O(n) runtime and O(n) space complexity. O(log(n)) space if this is a balanced binary tree.
 * There are two main ways to solve: Pass in to the recursive call whether this is
 * a left subtree, or check if the root's left child is a left subtree every time.
 * 4/10/2024 Winston Tsui
*/

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null && isLeft)
            return root.val;
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
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

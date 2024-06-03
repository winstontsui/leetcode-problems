/*
 * Leetcode 606: Construct String from Binary Tree. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * Recursive tree problem: deal with base case. Then, construct final string depending on whether there
 * is a left and right child appropriately, or if there are both.
 * 6/3/2024 Winston Tsui
*/

class Solution {
    public String tree2str(TreeNode root) {
        if (root == null)
            return "";

        // Now we know root has a value. Build up final string to be returned.
        if (root.left == null && root.right == null)
            return String.valueOf(root.val);
        if (root.left == null)
            return root.val + "()" + "(" + tree2str(root.right) + ")";
        if (root.right == null)
            return root.val + "(" + tree2str(root.left) + ")";

        // We know both children have a value.
        return root.val + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
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

/*
 * Leetcode 98: Validate Binary Search Tree. Java. Medium.
 * Recursive Algorithm. O(n) runtime and O(n) space complexity.
 * The key to this binary tree problem is that it's not enough to check
 * that the root's right child has a larger value than it, and its left child
 * has a smaller value than it. We have to keep track of the minimum and maximum 
 * bounds to ensure all leaf nodes obey the BST ordering property.
 * In the worst case, in a skewed BST, space complexity is O(n) but on average it's O(h).
 * 2/27/2024 Winston Tsui
*/

class Solution {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }

    private boolean validateBST(TreeNode root, Integer minValue, Integer maxValue) {
        if (root == null)
            return true;

        // Checking BST property.
        if (maxValue != null && root.val >= maxValue || minValue != null && root.val <= minValue)
            return false;

        return validateBST(root.left, minValue, root.val) && validateBST(root.right, root.val, maxValue);
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

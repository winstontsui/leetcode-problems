/*
 * Leetcode 104: Maximum Depth of Binary Tree. Java. Easy.
 * Recursive problem. O(n) runtime and O(log(n)) space complexity.
 * If at any point the node I'm at is null, the depth is 0.
 * Otherwise, the max depth is one more than the max depth of the left and right children.
 * 2/24/2024 Winston Tsui
*/

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
/*
 * Leetcode 2331: Evaluate Boolean Binary Tree. Java. Easy.
 * O(n) runtime and O(n) space complexity.
 * Do a postorder traversal to compute values of both subtrees. 
 * Then, compute the appropriate operation based on root.val.
 * 4/10/2024 Winston Tsui
*/

class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.val == 0)
            return false;
        if (root.val == 1)
            return true;

        // Postorder traversal: Compute values of both subtrees first, then do operation.
        boolean leftSubtree = evaluateTree(root.left);
        boolean rightSubtree = evaluateTree(root.right);
        if (root.val == 2)
            return leftSubtree || rightSubtree;
        return leftSubtree && rightSubtree;

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

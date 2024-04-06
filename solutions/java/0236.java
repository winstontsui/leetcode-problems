/*
 * Leetcode 236: Lowest Common Ancestor of a Binary Tree. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * 3 overarching cases: If root is either p or q, (or null), return root. 
 * If p and q are each in a subtree, return root.
 * If p and q are both in one subtree, (thus the other subtree is null), 
 * recursively return the LCA of the non-null subtree.
 * 4/6/2024 Winston Tsui
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;

        // At this point, we must traverse through both subtrees.
        // If left subtree and right subtree return a nonnull value, root is the LCA.
        // Otherwise, traverse down the nonnull subtree and return its LCA since both p
        // and q are in it!
        TreeNode leftSubtree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSubtree = lowestCommonAncestor(root.right, p, q);

        if (leftSubtree != null && rightSubtree != null)
            return root;
        if (leftSubtree != null)
            return leftSubtree;
        return rightSubtree;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

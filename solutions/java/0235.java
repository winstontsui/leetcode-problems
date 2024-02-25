/*
 * Leetcode 235: Lowest Common Ancestor of a Binary Search Tree. Java. Medium.
 * Interesting problem. O(n) runtime and O(h) space complexity.
 * The key is that this is a binary search tree. If current node is one of p or q's values, 
 * or is between p or q's value, it must be the lowest common ancestor. Otherwise look at the children.
 * This is not O(h) time complexity because in the worst case where there are only left child nodes, it is O(n).
 * O(h) time complexity has to do with whether the binary search tree is balanced.
 * 2/25/2024 Winston Tsui
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val < q.val || root.val > q.val && root.val < p.val || root.val == p.val
                || root.val == q.val)
            return root;

        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        return lowestCommonAncestor(root.right, p, q);
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

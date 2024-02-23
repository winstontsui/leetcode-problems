/*
 * Leetcode 100: Same Tree. Java. Easy.
 * DFS problem. O(n) runtime and O(h) space complexity, where h is the height of the tree.
 * Recursive problem--think about base cases and what conditions to return true or false.
 * The recursive case is going down the left and right subtrees and comparing them too.
 * 2/23/2024 Winston Tsui
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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

/*
 * Leetcode 404: Sum of Left Leaves. Java. Easy.
 * O(n) runtime and O(n) space complexity. O(log(n)) space if this is a balanced binary tree.
 * There are two main ways to solve: Pass in to the recursive call whether this is
 * a left subtree, or check if the root's left child is a leaf every time.
 * 4/10/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    // Recursive Solution
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

    // // Iterative Solution (Preorder traversal)
    // public int sumOfLeftLeaves(TreeNode root) {
    //     Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    //     stack.add(root);
    //     int sum = 0;

    //     while (!stack.isEmpty()) {
    //         TreeNode currNode = stack.remove();
    //         if (currNode.left != null) {
    //             if (currNode.left.left == null && currNode.left.right == null)
    //                 sum += currNode.left.val;
    //         }

    //         if (currNode.right != null)
    //             stack.addFirst(currNode.right);
    //         if (currNode.left != null)
    //             stack.addFirst(currNode.left);
    //     }

    //     return sum;
    // }

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

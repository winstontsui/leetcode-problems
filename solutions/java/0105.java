/*
 * Leetcode 105: Construct Binary Tree from Preorder and Inorder Traversal. Java. Medium.
 * O(n^2) runtime and O(n) space complexity.
 * Recursively take the first element of preorder (which is always the root), search it up in inorder,
 * and set the node's left and right subtrees to appropriate values in the preorder and inorder arrays
 * based on the size of the subtrees.
 * 5/1/2024 Winston Tsui
*/

import java.util.Arrays;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        TreeNode node = new TreeNode(preorder[0]);
        int index = 0;
        while (inorder[index] != preorder[0])
            index++;

        // Recursive calls depend on the length of left and right subtrees, so modify
        // preorder and postorder accordingly.
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return node;
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

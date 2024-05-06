/*
 * Leetcode 105: Construct Binary Tree from Preorder and Inorder Traversal. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * Recursively take the first element of preorder (which is always the root), search it up in inorder,
 * and set the node's left and right subtrees to appropriate values in the preorder and inorder arrays
 * based on the size of the subtrees. Use a HashMap to store values to indices.
 * 5/6/2024 Winston Tsui
*/

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildTree(preorder, map, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, HashMap<Integer, Integer> map, int preorderIndex, int left, int right) {
        if (right < left)
            return null;
        int index = map.get(preorder[preorderIndex]);
        TreeNode node = new TreeNode(preorder[preorderIndex]);

        node.left = buildTree(preorder, map, preorderIndex + 1, left, index - 1);
        node.right = buildTree(preorder, map, preorderIndex + (index - left) + 1, index + 1, right);
        return node;
    }

    // // Inefficient O(n^2) time complexity solution.
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     if (preorder.length == 0)
    //         return null;
    //     TreeNode node = new TreeNode(preorder[0]);
    //     int index = 0;
    //     while (inorder[index] != preorder[0])
    //         index++;

    //     // Recursive calls depend on the length of left and right subtrees, so modify
    //     // preorder and postorder accordingly.
    //     node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
    //     node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
    //             Arrays.copyOfRange(inorder, index + 1, inorder.length));

    //     return node;
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

/*
 * Leetcode 173: Binary Search Tree Iterator. Java. Medium.
 * O(1) average time complexity for `next()` and `hasNext()`, with O(h) space complexity, where h is the height of the tree.
 * The problem is solved using a stack to simulate in-order traversal. The stack is initialized with the leftmost path,
 * and for each `next()` call, the leftmost path of the current node's right child is processed.
 * 11/16/2024 Winston Tsui
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }

    }
    
    public int next() {
        // Pop from the stack and then while the peek node's left child is not null, add to stack.
        TreeNode curr = stack.pop();
        TreeNode peek = curr.right;

        while (peek != null){
            stack.push(peek);
            peek = peek.left;
        }

        return curr.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


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

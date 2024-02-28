/*
 * Leetcode 230: Kth Smallest Element in a BST. Java. Medium.
 * In-order BST traversal. O(n) runtime and O(n) spacetime.
 * Use nodesVisited[] to keep track of how many nodes I have visited.
 * Because this is in-order traversal, the kth element I find starting 
 * from the left subtree is the kth smallest element! 
 * 2/27/2024 Winston Tsui
*/

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return inOrderTraversal(root, k, new int[1]);
    }

    private int inOrderTraversal(TreeNode root, int k, int[] nodesVisited) {
        if (root == null)
            return -1;

        int left = inOrderTraversal(root.left, k, nodesVisited);
        if (left != -1) // If we already found the kth smallest element, just return!
            return left;

        nodesVisited[0]++;
        // Checking this current node (inOrderTraversal!!)
        if (nodesVisited[0] == k)
            return root.val;

        return inOrderTraversal(root.right, k, nodesVisited);
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

/*
 * Leetcode 129: Sum Root to Leaf Numbers. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * Uses preorder depth-first search traversal to keep track of currentSum up to the leaf.
 * Add the result to a global sum variable.
 * 4/4/2024 Winston Tsui
*/

class Solution {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return sum;
    }

    private void sumNumbers(TreeNode root, int currSum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            sum = sum + (currSum * 10 + root.val);

        if (root.left != null)
            sumNumbers(root.left, currSum * 10 + root.val);
        if (root.right != null)
            sumNumbers(root.right, currSum * 10 + root.val);
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

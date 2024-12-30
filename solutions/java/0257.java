/*
 * Leetcode 257: Binary Tree Paths. Java. Easy.
 * O(n) runtime and O(h) space complexity, where n is the number of nodes and h is the height of the tree.
 * This solution uses recursive DFS to generate all root-to-leaf paths in a binary tree.
 * A string is used to track the current path, which is added to the result list when a leaf node is reached.
 * Insights: By appending "->" to the path only when exploring children, the solution ensures proper formatting for the paths.
 * 12/29/2024 Winston Tsui
 */

import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null)
            return ans;

        binaryTreePaths(root, "", ans);

        return ans;
    }

    private void binaryTreePaths(TreeNode root, String curr, List<String> ans) {
        if (root == null)
            return;

        curr += root.val;

        if (root.left == null && root.right == null) {
            ans.add(curr);
            return;
        } else {
            curr += "->";
            binaryTreePaths(root.left, curr, ans);
            binaryTreePaths(root.right, curr, ans);
        }

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

/*
 * Leetcode 113: Path Sum II. Java. Medium.
 * O(n*log(n)) runtime and O(n) space complexity.
 * Use currSum to keep track of sum up to a certain point and a List curr to track of the current path.
 * Use backtracking and dfs to add curr to ans if this path equals sum.
 * 4/9/2024 Winston Tsui
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        pathSumHelper(root, targetSum, ans, curr, 0);
        return ans;
    }

    private void pathSumHelper(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> curr, int currSum) {
        if (root == null)
            return;
        // I use currSum to keep track of the sum from the base root to this node.
        if (root.left == null && root.right == null && currSum + root.val == targetSum) {
            ArrayList<Integer> newlist = new ArrayList<Integer>(curr);
            newlist.add(root.val);
            ans.add(newlist);
        }

        curr.add(root.val);
        pathSumHelper(root.left, targetSum, ans, curr, currSum + root.val);
        pathSumHelper(root.right, targetSum, ans, curr, currSum + root.val);
        curr.remove(curr.size() - 1);

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

/*
 * Leetcode 1457: Pseudo-Palindromic Paths in a Binary Tree. Java. Medium.
 * O(n) runtime and O(h + k) space complexity, where n is the number of nodes, h is the height of the tree, and k is the maximum unique values in a path.
 * This solution uses backtracking with a HashSet to track node values in the current path.
 * The algorithm toggles the presence of a node value in the set and checks if at most one value has an odd frequency (pseudo-palindromic condition) at leaf nodes.
 * Insights: Backtracking ensures that the set is restored after each recursive call, allowing efficient exploration of all paths.
 * 12/30/2024 Winston Tsui
 */

import java.util.*;

class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        return helper(root, new HashSet<>());
    }

    private int helper(TreeNode root, HashSet<Integer> values) {
        if (root == null)
            return 0;

        if (values.contains(root.val))
            values.remove(root.val);
        else
            values.add(root.val);

        // Node values of a path form a palindrome if at most one digit has an odd
        // frequency
        int count = 0;
        if (root.left == null && root.right == null && values.size() <= 1)
            count = 1;

        count = count + helper(root.left, values) + helper(root.right, values);

        // Backtrack
        if (values.contains(root.val))
            values.remove(root.val);
        else
            values.add(root.val);

        return count;
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

// // O(n * k) time and space complexity. k due to creation of a new HashSet during each recursive call.
// class Solution {
//     public int pseudoPalindromicPaths(TreeNode root) {
//         return helper(root, new HashSet<>());
//     }

//     private int helper(TreeNode root, HashSet<Integer> values) {
//         if (root == null)
//             return 0;

//         if (values.contains(root.val))
//             values.remove(root.val);
//         else
//             values.add(root.val);

//         if (root.left == null && root.right == null && values.size() <= 1)
//             return 1;

//         return helper(root.left, new HashSet<>(values)) + helper(root.right, new HashSet<>(values));

//     }
// }

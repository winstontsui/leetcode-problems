/*
 * Leetcode 513: Find Bottom Left Tree Value. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * Perform BFS in a layered manner, tracking the leftmost value of every layer in a variable.
 * 8/12/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        int ans = root.val;
        deque.add(root);
        // bfs level order traversal
        while (!deque.isEmpty()) {
            int size = deque.size();

            // Always finds the leftmost value of each level
            if (size > 0)
                ans = deque.peek().val;

            // Add nodes of the next level if they exist
            while (size-- > 0) {
                TreeNode curr = deque.remove();
                if (curr.left != null)
                    deque.add(curr.left);
                if (curr.right != null)
                    deque.add(curr.right);
            }
        }
        return ans;
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

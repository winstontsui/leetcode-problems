/*
 * Leetcode 199: Binary Tree Right Side View. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * Not a well worded problem. To get the rightmost element of every level in the tree, 
 * this solution uses BFS in a layered traversal, adding the last (rightmost) element to ans.
 * 5/22/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        if (root != null)
            deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            TreeNode curr = null;

            while (size > 0) {
                curr = deque.remove();
                if (curr.left != null)
                    deque.add(curr.left);
                if (curr.right != null)
                    deque.add(curr.right);
                size--;
            }
            ans.add(curr.val);
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

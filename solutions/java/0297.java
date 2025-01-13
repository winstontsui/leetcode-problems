/*
 * Leetcode 297: Serialize and Deserialize Binary Tree. Java. Hard.
 * O(n) runtime and O(n) space complexity for both serialization and deserialization.
 * Uses iterative preorder traversal for serialization and recursive preorder traversal for deserialization.
 * Iterative serialization avoids recursion stack overflow, while recursive deserialization simplifies reconstruction logic.
 * #TODO: Try recursive serialize and iterative deserialize. Also try level order traversal.
 * Insights: Handles null values explicitly with "null" to maintain tree structure during traversal.
 * 1/13/2025 Winston Tsui
 */

import java.util.*;

class Codec {
    // Serialize the tree using iterative preorder traversal
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";

        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                // Push right first, so left is processed first
                stack.push(node.right);
                stack.push(node.left);
            }
        }

        // Remove trailing comma
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    int i = 0;
    // Deserialize the tree using recursive preorder traversal
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        return deserializeHelper(values);
    }

    private TreeNode deserializeHelper(String[] values) {
        if (values[i].equals("null")) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(values[i]));
        i++;
        node.left = deserializeHelper(values);
        node.right = deserializeHelper(values);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

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

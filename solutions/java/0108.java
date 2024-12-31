/*
 * Leetcode 108: Convert Sorted Array to Binary Search Tree. Java. Easy.
 * O(n) runtime and O(log n) space complexity.
 * Uses a divide-and-conquer approach to recursively select the middle element of the array as the root.
 * The left half of the array forms the left subtree, and the right half forms the right subtree.
 * Insights: By recursively dividing the array, the tree remains height-balanced, ensuring optimal performance.
 * 12/30/2024 Winston Tsui
 */

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return binarySearch(0, nums.length - 1, nums);
    }

    private TreeNode binarySearch(int l, int r, int[] nums) {
        if (l <= r) {
            int m = l + (r - l) / 2;
            
            // Create the root node with the middle element
            return new TreeNode(
                    nums[m],
                    binarySearch(l, m - 1, nums), // Left subtree
                    binarySearch(m + 1, r, nums) // Right subtree
            );
        }
        return null;
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

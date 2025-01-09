/*
 * Leetcode 109: Convert Sorted List to Binary Search Tree. Java. Medium.
 * O(n log n) runtime and O(log n) space complexity due to recursion.
 * Recursively constructs a height-balanced Binary Search Tree (BST) from a sorted singly linked list. 
 * Uses a slow and fast pointer to find the middle node, which serves as the root of the BST.
 * Insights: The left half of the list (before the middle) forms the left subtree, while the right half (after the middle) forms the right subtree.
 * 1/8/2025
 */

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        // If there's only one node, it becomes the root
        if (head.next == null)
            return new TreeNode(head.val);

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect the left half from the middle
        prev.next = null;

        // Middle node becomes the root
        TreeNode curr = new TreeNode(slow.val);

        // Recursively build the left and right subtrees
        curr.left = sortedListToBST(head);
        curr.right = sortedListToBST(slow.next);
        return curr;
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

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

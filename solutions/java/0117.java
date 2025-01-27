/*
 * Leetcode 117: Populating Next Right Pointers in Each Node II. Java. Medium.
 * O(n) runtime and O(1) space complexity (excluding recursion stack).
 * Traverses each level of the binary tree using a dummy node to track the start of the next level.
 * At each level, connects left and right children to form `next` pointers for the next level.
 * Key Insight: A dummy node simplifies managing the level-by-level traversal without extra space.
 * Tricky Part: Handle sparse trees efficiently and move to the next level correctly.
 * 1/26/2025 Winston Tsui
*/

class Solution {
    public Node connect(Node root) {
        Node curr = root;

        // Traverse through each level
        while (curr != null) {
            Node dummy = new Node(0); // Tracks start of next level
            Node tail = dummy; // Tracks current rightmost node of next level

            // Traverse through each node in a level
            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                curr = curr.next; // Move to the next node in the same level
            }
            // Move to the first node of the next level
            curr = dummy.next;
        }

        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

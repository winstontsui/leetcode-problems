/*
 * Leetcode 116: Populating Next Right Pointers in Each Node. Java. Medium.
 * O(n) runtime and O(1) space complexity.
 * Uses level-by-level traversal to connect the next pointers of a perfect binary tree.
 * The algorithm connects the left and right children of each node, and the right child
 * to the left child of the next node. Moves to the next level using the leftmost pointer.
 * Insights: Efficiently leverages the tree's structure without additional data structures.
 * 1/18/2025
 */

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;

        Node leftMost = root;
        while (leftMost.left != null) {
            Node curr = leftMost;

            while (curr != null) {
                // Connect left child to right child
                curr.left.next = curr.right;

                // Connect right child to the next node's left child
                if (curr.next != null)
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }

            leftMost = leftMost.left;
        }
        return root;
    }
}

// class Solution {
//     public Node connect(Node root) {
//         if (root == null)
//             return root;

//         Deque<Node> deque = new ArrayDeque<>();
//         deque.add(root);
//         while (!deque.isEmpty()) {
//             int size = deque.size();
//             for (int i = 0; i < size; i++) {
//                 Node curr = deque.remove();
//                 curr.next = i == size - 1 ? null : deque.peek();
//                 if (curr.left != null)
//                     deque.add(curr.left);
//                 if (curr.right != null)
//                     deque.add(curr.right);
//             }
//         }
//         return root;
//     }
// }

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

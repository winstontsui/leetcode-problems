/*
 * Leetcode 138: Copy List with Random Pointer. Java. Medium.
 * O(n) runtime and O(1) space complexity (excluding output space).
 * Create a deep copy of a linked list where each node has `next` and `random` pointers.
 * Interweave new nodes with old ones to maintain O(1) space, using original nodes to determine `random` links.
 * Separate the new list by restoring the original list and extracting the deep copy.
 * Tricky part: Ensure both lists are restored and deep copied without breaking the structure.
 * 1/25/2025 Winston Tsui
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // 1. Interweave old and new nodes in list.
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        // 2. Connect random pointers in new nodes.
        temp = head;
        while (temp != null) {
            if (temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }

        // 3. Separate the original and new nodes to finalize the new list.
        Node newList = head.next;
        Node tempOldList = head;
        Node tempNewList = head.next;

        while (tempOldList != null) {
            tempOldList.next = tempOldList.next.next;
            tempNewList.next = tempNewList.next == null ? null : tempNewList.next.next;

            tempOldList = tempOldList.next;
            tempNewList = tempNewList.next;
        }
        return newList;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

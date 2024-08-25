/*
 * Leetcode 61: Rotate List. Java. Medium.
 * O(n) runtime and O(1) space complexity.
 * Determine length of list, calculate effective rotation length and use pointers to rotate list.
 * 8/25/2024 Winston Tsui
*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

        int size = 0;
        ListNode temp = head;
        ListNode front = head;
        ListNode back = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        k %= size;

        if (k == 0)
            return head;

        while (k-- > 0)
            front = front.next;

        while (front.next != null) {
            front = front.next;
            back = back.next;
        }

        ListNode newhead = back.next;
        back.next = null;
        front.next = head;

        return newhead;
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

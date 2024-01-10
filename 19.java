/*
 * Leetcode 19: Remove Nth Node From End of List. Java. Easy.
 * Interesting LinkedList problem. O(n) runtime and O(1) space complexity.
 * Trick is to deal with different cases. Count distance remaining to remove the Nth node.
 * 1/9/2024 Winston Tsui
*/

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1)
            return null;

        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        if (count == n)
            return head.next;

        // Distance remaining. Restart from beginning,
        count = count - n;
        temp = head;
        while (count > 1) {
            count--;
            temp = temp.next;
        }

        if (temp.next.next == null) {
            temp.next = null;
            return head;
        }
        temp.next = temp.next.next;
        return head;
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

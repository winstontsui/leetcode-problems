/*
 * Leetcode 24: Swap Nodes in Pairs. Java. Medium.
 * O(1) runtime and O(capacity) space complexity.
 * Starting from a previous node, swap nodes in the linked list in pairs by going in steps of 2.
 * 7/1/2024 Winston Tsui
*/

class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;

            first.next = second.next;
            second.next = first;
            curr.next = second;

            curr = first;
        }
        return dummy.next;
    }
}

// // Recursive Solution: Starting from the last pair, swap and return the second reversed element. 
// // O(n) time and O(n) space complexity.
// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         if (head == null || head.next == null)
//             return head;
//         ListNode rest = swapPairs(head.next.next);
//         ListNode second = head.next;
//         second.next = head;
//         head.next = rest;
//         return second;
//     }
// }

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

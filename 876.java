/*
 * Leetcode 237: Middle of the Linked List. Java. Easy.
 * Straightforward LinkedList problem. O(n) runtime and O(1) space complexity.
 * I can also have two pointers-- a fast and a slow pointer. Fast goes twice as quickly as slow.
 * 1/9/2024 Winston Tsui
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        temp = head;
        count /= 2;
        while (count > 0) {
            temp = temp.next;
            count--;
        }
        return temp;
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

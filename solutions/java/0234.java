/*
 * Leetcode 234: Palindrome Linked List. Java. Easy.
 * O(n) runtime and O(1) space complexity.
 * Go up to the middle of the list and reverse the second half. Run through the linkedlist again, 
 * determining if the first half is equivalent to the second half one element at a time.
 * 6/26/2024 Winston Tsui
 */

class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode lastHalf = reverse(slow);

        while (lastHalf != null) {
            if (head.val != lastHalf.val) {
                return false;
            }
            head = head.next;
            lastHalf = lastHalf.next;
        }
        return true;
    }

    private ListNode reverse(ListNode start) {
        ListNode prev = null;

        while (start != null) {
            ListNode temp = start.next;
            start.next = prev;
            prev = start;
            start = temp;
        }
        return prev;
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
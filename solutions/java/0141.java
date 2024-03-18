/*
 * Leetcode 141: Linked List Cycle. Java. Easy.
 * O(n) runtime and O(1) space complexity.
 * Use a slow and fast pointer, which goes one and two steps ahead, respectively. 
 * If at any point when we traverse the list and these pointers equal each other, there MUST be a cycle.
 * 3/18/2024 Winston Tsui
*/

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

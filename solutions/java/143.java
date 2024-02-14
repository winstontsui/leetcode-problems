/*
 * Leetcode 143: Reorder List. Java. Medium.
 * Tough and excruciating linked list problem. O(n) runtime and O(1) spacetime.
 * Reverse second half of the linkedlist and merge the two lists together
 * by taking one node from the first list, a node from the second list repeatedly.
 * 2/14/2024 Winston Tsui
*/

class Solution {
    public void reorderList(ListNode head) {
        ListNode temp = head;
        ListNode middle = findMiddle(head);
        middle = reverse(middle);
        merge(temp, middle);
    }

    // Returns the node right after the middle of linkedlist.
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Breaks up into two lists.
        ListNode next = slow.next;
        slow.next = null;
        return next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // Merges two linked lists into one by taking one node from first,
    // then one node from second and so on repeatedly.
    private void merge(ListNode first, ListNode second) {
        while (second != null) {
            ListNode after1 = first.next;
            ListNode after2 = second.next;
            first.next = second;
            second.next = after1;
            first = after1;
            second = after2;
        }
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

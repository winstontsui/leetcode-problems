/*
 * Leetcode 83: Remove Duplicates from Sorted List. Java. Easy.
 * O(n) runtime and O(1) space complexity.
 * Because the input list is sorted, simply compare the current element to the next element. If they equal, remove the second element.
 * 7/2/2024 Winston Tsui
 */

 class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;

        while (temp.next != null) {
            ListNode second = temp.next;
            if (second.val == temp.val) {
                temp.next = second.next; 
            }else {
                temp = temp.next;
            }
        }
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

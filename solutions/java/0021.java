/*
 * Leetcode 21: Merge Two Sorted Lists. Java. Easy.
 * O(n) runtime and O(1) space complexity.
 * Iteratively process nodes in list1 and list2 by their value, combining them.
 * 6/22/2024 Winston Tsui
 */

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // temp1 and temp2 pointers aren't necessary.
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode ans = new ListNode();
        ListNode tempAns = ans;

        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                tempAns.next = temp1;
                tempAns = tempAns.next;
                temp1 = temp1.next;
            } else {
                tempAns.next = temp2;
                tempAns = tempAns.next;
                temp2 = temp2.next;
            }
        }

        if (temp1 != null) {
            tempAns.next = temp1;
        }
        if (temp2 != null) {
            tempAns.next = temp2;
        }

        return ans.next;
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

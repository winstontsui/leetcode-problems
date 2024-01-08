/*
 * Leetcode 237: 4Sum. Java. Medium.
 * Wierdly worded but simple problem. O(n) runtime and O(1) space complexity.
 * There is a much better runtime solution in O(1) time where you simply set 
 * node's val to the next val, then set node.next to be node.next.next.
 * 1/7/2024 Winston Tsui
*/

class Solution237 {
    public void deleteNode(ListNode node) {
        // Generally I should keep track of head of linklist so it doesn't get wiped out,
        // but here it isn't necessary.
        while (node.next != null) {
            node.val = node.next.val;
            if (node.next.next == null) {
                node.next = null;
                break;
            }
            node = node.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
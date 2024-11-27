/*
 * Leetcode 23: Merge k Sorted Lists. Java. Hard.
 * O(n log k) runtime and O(k) space complexity, where n is the total number of nodes across all lists and k is the number of lists.
 * The problem is solved using a min-heap (priority queue) to efficiently extract the smallest element from the heads of k sorted lists.
 * The extracted node is added to the merged list, and its next node is pushed into the heap. This continues until all nodes are processed.
 * 11/27/2024 Winston Tsui
 */

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)
            return null;

        ListNode sortedList = new ListNode();
        ListNode curr = sortedList;
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));

        for (ListNode node : lists)
            if (node != null)
                minHeap.add(node);

        while (!minHeap.isEmpty()) {
            ListNode next = minHeap.remove();
            curr.next = new ListNode(next.val);
            curr = curr.next;
            if (next.next != null)
                minHeap.add(next.next); // Add the next node from the same list
        }
        return sortedList.next;
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

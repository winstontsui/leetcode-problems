/*
 * Leetcode 2: Add Two Numbers. Java. Medium.
 * Deceptively simple problem. O(max(m, n)) runtime and O(max(m, n)) spacetime solution.
 * When adding numbers, be careful incorporating previous carry values and computing expected sums.
 * A new node/digit at the end may be necessary.
 * 3/6/2024 Winston Tsui
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode();
        ListNode current = newList;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode((sum + carry) % 10);
            current = current.next;
            carry = (sum + carry) / 10;
        }
        if (carry == 1)
            current.next = new ListNode(1);

        return newList.next;
    }
}

// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode newList = new ListNode();
//         ListNode current = newList;
//         int carry = 0;

//         while (l1 != null && l2 != null) {
//             current.next = new ListNode((carry + l1.val + l2.val) % 10);
//             carry = (carry + l1.val + l2.val) / 10;
//             current = current.next;
//             l1 = l1.next;
//             l2 = l2.next;
//         }

//         while (l1 != null) {
//             current.next = new ListNode((carry + l1.val) % 10);
//             carry = (carry + l1.val) / 10;
//             current = current.next;
//             l1 = l1.next;
//         }

//         while (l2 != null) {
//             current.next = new ListNode((carry + l2.val) % 10);
//             carry = (carry + l2.val) / 10;
//             current = current.next;
//             l2 = l2.next;
//         }

//         if (carry == 1)
//             current.next = new ListNode(1);

//         return newList.next;
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

/*
 * Leetcode 146: LRU Cache. Java. Medium.
 * O(1) runtime and O(capacity) space complexity.
 * Use a doubly linked list to order elements from LRU(left) to most recently used(right). Use a hashmap to access nodes fast.
 * 6/29/2024 Winston Tsui
*/

import java.util.HashMap;

class LRUCache {
    ListNode left = new ListNode(); // Least recently used
    ListNode right = new ListNode(); // Most recently used
    HashMap<Integer, ListNode> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // Mark node as most recently used. Remove it and insert it at the right.
            int payload = map.get(key).val;
            remove(key);
            insert(key, payload);
            return payload;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
            remove(key);
        insert(key, value);
        if (map.size() > capacity)
            remove(left.next.key);
    }

    private void remove(int key) {
        ListNode toRemove = map.get(key);
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
        map.remove(key);
    }

    // Always insert to most recently used spot.
    private void insert(int key, int value) {
        ListNode toInsert = new ListNode(key, value);
        right.prev.next = toInsert;
        toInsert.prev = right.prev;
        right.prev = toInsert;
        toInsert.next = right;
        map.put(key, toInsert);
    }
}

// Doubly linked list, prev is needed to add and remove cache elements.
// key is a necessary parameter when removing the LRU element during capacity overflows--we need to do remove(left.next.key) from the hashmap.
class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode() {
    }

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

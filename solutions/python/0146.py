"""
 * Leetcode 146: LRU Cache. Python. Medium.
 * O(1) time complexity for both get and put operations
 * Uses a doubly linked list and hash map for efficient operations.
 *
 * Example:
 * Input:
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output: [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 7/16/2025 Winston Tsui
"""

class Node:
    def __init__(self, key: int, value: int):
        self.key, self.value = key, value
        self.next = self.prev = None

class LRUCache:
    def __init__(self, capacity: int):
        """
        Initialize the LRU cache with positive size capacity.
        Uses a dictionary for O(1) lookups and a doubly linked list
        to maintain the order of usage.
        """
        self.capacity = capacity
        self.dict = {}
        self.l = Node(0, 0)  # LRU (dummy head)
        self.r = Node(0, 0)  # MRU (dummy tail)
        self.l.next, self.r.prev = self.r, self.l

    def _insertToEnd(self, node):
        """Insert node at MRU position (before right node)."""
        node.prev, node.next = self.r.prev, self.r
        self.r.prev.next, self.r.prev = node, node

    def _remove(self, node):
        """Remove a node from the doubly linked list."""
        node.prev.next, node.next.prev = node.next, node.prev

    def get(self, key: int) -> int:
        """
        Returns the value of the key if it exists, otherwise returns -1.
        Moves the accessed node to MRU position.
        """
        if key in self.dict:
            self._remove(self.dict[key])
            self._insertToEnd(self.dict[key])
            return self.dict[key].value
        return -1

    def put(self, key: int, value: int) -> None:
        """
        Updates the value of the key if it exists, or adds the key-value pair.
        If the number of keys exceeds capacity, evicts the least recently used key.
        """
        if key in self.dict:
            self._remove(self.dict[key])
        
        newNode = Node(key, value)
        self.dict[key] = newNode
        self._insertToEnd(newNode)

        if len(self.dict) > self.capacity:
            lru = self.l.next
            self._remove(lru)
            del self.dict[lru.key]

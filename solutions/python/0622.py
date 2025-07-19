"""
 * Leetcode 622: Design Circular Queue. Python. Medium.
 * O(1) time complexity for all operations, O(n) space complexity
 * Uses a fixed-size list with front and back pointers for efficient operations.
 *
 * Example:
 * ["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * Output: [null, true, true, true, false, 3, true, true, true, 4]
 *
 * 7/17/2025 Winston Tsui
"""

class MyCircularQueue:
    """
    Circular queue implementation with a fixed size.
    Supports enqueue, dequeue, front, rear, isEmpty, and isFull operations.
    """
    def __init__(self, k: int):
        """Initialize your data structure with size k."""
        self.capacity = k
        self.queue = [0] * self.capacity  # Fixed-size circular buffer
        self.front = 0  # Points to the front element
        self.back = -1   # Points to the last element
        self.size = 0    # Tracks current number of elements

    def enQueue(self, value: int) -> bool:
        """Insert an element into the circular queue. Return true if successful."""
        if self.isFull():
            return False

        self.back = (self.back + 1) % self.capacity
        self.queue[self.back] = value
        self.size += 1
        return True

    def deQueue(self) -> bool:
        """Delete an element from the circular queue. Return true if successful."""
        if self.isEmpty():
            return False

        self.front = (self.front + 1) % self.capacity
        self.size -= 1
        return True

    def Front(self) -> int:
        """Get the front item from the queue. Returns -1 if empty."""
        if self.isEmpty():
            return -1
        return self.queue[self.front]

    def Rear(self) -> int:
        """Get the last item from the queue. Returns -1 if empty."""
        if self.isEmpty():
            return -1
        return self.queue[self.back]

    def isEmpty(self) -> bool:
        """Check whether the circular queue is empty."""
        return self.size == 0

    def isFull(self) -> bool:
        """Check whether the circular queue is full."""
        return self.size == self.capacity

# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()

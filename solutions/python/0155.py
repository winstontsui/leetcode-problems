"""
 * Leetcode 155: Min Stack. Python. Easy.
 * O(1) time complexity for all operations, O(n) space complexity
 * Uses a stack that stores (value, current_min) tuples to track minimum efficiently.
 *
 * Example:
 * Input:
 * ["MinStack","push(-2)","push(0)","push(-3)","getMin","pop","top","getMin"]
 * [[],[],[],[],[],[],[],[]]
 * Output: [null,null,null,null,-3,null,0,-2]
 *
 * 7/17/2025 Winston Tsui
"""

class MinStack:
    """
    Stack that supports push, pop, top, and retrieving the minimum element in constant time.
    """
    def __init__(self):
        # Stack elements are tuples of (value, current_minimum)
        self.stack = []

    def push(self, val: int) -> None:
        """Pushes the element val onto the stack."""
        new_min = val
        if self.stack:
            new_min = min(new_min, self.stack[-1][1])
        self.stack.append((val, new_min))

    def pop(self) -> None:
        """Removes the element on the top of the stack."""
        self.stack.pop()

    def top(self) -> int:
        """Gets the top element of the stack."""
        return self.stack[-1][0]

    def getMin(self) -> int:
        """Retrieves the minimum element in the stack."""
        return self.stack[-1][1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

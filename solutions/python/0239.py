"""
Leetcode 239: Sliding Window Maximum. Python. Hard.
O(N) runtime and O(K) space complexity, where N is the number of elements and K is the window size.
Usee a monotonic deque to track max elements in each sliding window.
Remove stale indices as the window moves.
3/31/2025 Winston Tsui
"""

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        maxWindow = []
        deque = collections.deque()

        # Stores indices of elements in the window, front is the max
        l = r = 0
        while r < len(nums):
            # Keep only the greatest element in the back of deque (monotonically decreasing deque)
            while deque and nums[r] > nums[deque[-1]]:
                deque.pop()
            deque.append(r)

            # Remove indicies out of current window
            if deque[0] < l:
                deque.popleft()

            # Append to maxWindow once window reaches size k and update window left boundary
            if r + 1 >= k:
                maxWindow.append(nums[deque[0]])
                l += 1
            r += 1

        return maxWindow

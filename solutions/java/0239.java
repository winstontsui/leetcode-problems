import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Monotonic decreasing deque storing indices of nums, where the leftmost element is the greatest number.
        Deque<Integer> deque = new ArrayDeque<>();
        int[] maxWindow = new int[nums.length - k + 1];
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            // Remove indices that are out of bounds (outside the current window)
            if (!deque.isEmpty() && deque.peekFirst() < r - k + 1) {
                deque.pollFirst();
            }

            // Remove elements from the deque that are smaller than the current element
            // because they are not useful anymore.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                deque.pollLast();
            }

            // Add the current element index to the deque
            deque.addLast(r);

            // Once the window size reaches at least 'k', start adding results
            if (r >= k - 1) {
                maxWindow[l] = nums[deque.peekFirst()];
                l++;
            }
        }
        
        return maxWindow;
    }
}

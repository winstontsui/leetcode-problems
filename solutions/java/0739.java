/*
 * Leetcode 739: Daily Temperatures. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * Use a Monotonic Stack containing temperatures and indicies and where elements are sorted by decreasing temperatures.
 * As we traverse, seeing warmer temperatures indicate a need to pop the stack until we don't or until the stack is empty.
 * Appropriately populate the ans array using the current index and the popped stack index.
 * 6/8/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        // element[0] holds temperature value, element[1] holds its index.
        Deque<Integer[]> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                Integer[] top = stack.pop();
                ans[top[1]] = i - top[1];
            }
            stack.addFirst(new Integer[]{temperatures[i], i});
        }
        return ans;
    }
}

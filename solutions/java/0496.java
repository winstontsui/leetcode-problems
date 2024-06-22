/*
 * Leetcode 496: Next Greater Element I. Java. Easy.
 * O(n) runtime and O(n) space complexity.
 * Nightmarish problem. Use a HashMap mapping each number in nums2 to its next greater element.
 * Use a monotonically increasing stack but traverse through nums2 backwards to get the next greater element.
 * 6/21/2024 Winston Tsui
 */

import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> nextGreaterNumber = new HashMap<>();
        Stack<Integer> monotonicStack = new Stack<>(); // Monotonically increasing stack
        monotonicStack.add(nums2[nums2.length-1]);
        nextGreaterNumber.put(nums2[nums2.length-1], -1);

        for (int i = nums2.length-2; i > -1; i--){
            while (!monotonicStack.isEmpty() && monotonicStack.peek() < nums2[i])
                monotonicStack.pop();
            if (monotonicStack.isEmpty())
               nextGreaterNumber.put(nums2[i], -1); 
            else
                nextGreaterNumber.put(nums2[i], monotonicStack.peek());
            monotonicStack.add(nums2[i]);
        }
        
        for (int i = 0; i < nums1.length; i++)
            ans[i] = nextGreaterNumber.get(nums1[i]);

        return ans;
    }
}

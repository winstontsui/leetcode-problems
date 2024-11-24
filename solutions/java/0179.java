/*
 * Leetcode 179: Largest Number. Java. Medium.
 * O(n log n) runtime and O(n) space complexity, where n is the number of integers in the input array.
 * The problem is solved using a max-heap (priority queue) with a custom comparator to order numbers
 * based on concatenation results. 
 * For two strings, if x+y>y+x, x should come before 𝑦. Otherwise, y should come before x.
 * 11/24/2024 Winston Tsui
 */

import java.util.PriorityQueue;

class Solution {
    public String largestNumber(int[] nums) {
        // Order numbers based on custom comparator using max heap.
        PriorityQueue<String> strings = new PriorityQueue<>((a, b) -> ((b + a).compareTo(a + b)));

        // Add all numbers as strings to the priority queue
        for (int num : nums)
            strings.add(String.valueOf(num));

        // Handle edge case where the largest number is "0"
        if (strings.peek().equals("0"))
            return "0";

        // Build up answer
        StringBuilder ans = new StringBuilder();
        while (!strings.isEmpty())
            ans.append(strings.poll());

        return ans.toString();
    }
}

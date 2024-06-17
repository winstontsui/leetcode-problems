/*
 * Leetcode 1046: Last Stone Weight. Java. Easy.
 * O(nlogn) runtime and O(n) space complexity.
 * Trick is to use a max heap, which finds the maximum element in O(1) time. 
 * Modify this heap by adding and removing items as necessary.
 * 6/17/2024 Winston Tsui
 */

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones)
            maxHeap.add(stone);

        while (!maxHeap.isEmpty()) {
            int first = maxHeap.remove();
            if (maxHeap.isEmpty())
                return first;

            int second = maxHeap.remove();
            maxHeap.add(first - second);
        }
        
        return 0;
    }
}

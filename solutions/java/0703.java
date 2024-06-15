/*
 * Leetcode 703: Kth Largest Element in a Stream. Java. Easy.
 * O(nlogk) runtime and O(k) space complexity.
 * Create a heap of size k holding the largest k elements. When the size of the heap exceeds k, 
 * start removing elements to preserve the kth largest element (by calling heap.peek()).
 * 6/15/2024 Winston Tsui
 */

import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {
    Queue<Integer> heap = new PriorityQueue<>(); // Min heap
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) 
                heap.remove();
        }
    }

    public int add(int val) {
        if (heap.size() < k)
            heap.add(val);
        else {
            if (val > heap.peek()) {
                heap.remove();
                heap.add(val);
            }
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

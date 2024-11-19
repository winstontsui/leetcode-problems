/*
 * Leetcode 295: Find Median from Data Stream. Java. Hard.
 * O(log n) runtime for addNum() and O(1) runtime for findMedian(), with O(n) space complexity.
 * The problem is solved using two heaps: a max-heap to store the smaller half of the elements including median,
 * and a min-heap to store the larger half. The heaps are balanced such that the median is always
 * accessible as either the root of one heap or the average of the roots of both heaps.
 * 11/18/2024 Winston Tsui
 */

import java.util.PriorityQueue;

class MedianFinder {
    // minHeap contains largest n/2 elements, maxHeap contains smallest n/2 +
    // possible median element
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        maxHeap.add(num); // Ensures only biggest n/2 elements are in minHeap.
        minHeap.add(maxHeap.remove());
        if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.remove());
    }

    public double findMedian() {
        // Even number of elements
        if (minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2.0;

        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

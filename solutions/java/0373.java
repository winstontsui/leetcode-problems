/*
 * Leetcode 373: Find K Pairs with Smallest Sums. Java. Medium.
 * O(klogk) runtime and O(k) space complexity.
 * Initialize a min-heap with pairs involving the first element of nums2 and subsequently 
 * adding the next elements from nums2 for the current minimum element from nums1.
 * 6/11/2024 Winston Tsui
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<List<Integer>> ans = new ArrayList<>();

        // Add every element in nums1 with first element in nums2.
        for (int i = 0; i < k && i < nums1.length; i++) {
            heap.add(new int[]{nums1[i], nums2[0], 0}); // 0 is the index in nums2
        }

        // Heap will always be size k. Each loop removes and adds one item from heap.
        while (k-- > 0) {
            int[] arr = heap.remove();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(arr[0]);
            temp.add(arr[1]);
            ans.add(temp);

            if (arr[2] + 1 < nums2.length) {
                heap.add(new int[]{arr[0], nums2[arr[2] + 1], arr[2] + 1});
            }
        }
        return ans;
    }
}

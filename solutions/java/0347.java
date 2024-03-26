/*
 * Leetcode 347: Top K Frequent Elements. Java. Medium.
 * O(n*log(k)) runtime and O(n) space complexity. 
 * Use a HashMap to keep track of number frequencies and a MaxHeap (PriorityQueue)
 * to store the top k elements based on its frequency.
 * 3/26/2024 Winston Tsui
*/

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        // HashMap<Element, [Element, freq]>
        HashMap<Integer, Integer[]> freq = new HashMap<Integer, Integer[]>();
        for (int i : nums) {
            if (!freq.containsKey(i))
                freq.put(i, new Integer[] { i, 1 });
            else
                freq.get(i)[1] += 1;
        }

        // Stores top K frequent elements in a maxheap
        PriorityQueue<Integer[]> maxHeap = new PriorityQueue<Integer[]>((a, b) -> b[1] - a[1]);

        for (Integer[] currFreq : freq.values()) {
            if (k > -1)
                maxHeap.add(currFreq);
            else {
                maxHeap.remove();
                maxHeap.add(currFreq);
            }
        }
        for (int i = 0; i < ans.length; i++)
            ans[i] = maxHeap.remove()[0];
        return ans;
    }
}

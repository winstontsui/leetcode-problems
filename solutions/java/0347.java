/*
 * Leetcode 347: Top K Frequent Elements. Java. Medium.
 * O(n) runtime and O(n) space complexity using bucket sort.
 * Counts frequencies of elements in nums and groups them into buckets where the index represents frequency.
 * Iterates over buckets from highest to lowest frequency to collect the top k elements.
 * Insights: The bucket index corresponds to frequency, ensuring efficient access to most frequent elements.
 * 
 * Heap Approach:
 * O(n*log(k)) runtime and O(n) space complexity. 
 * Use a HashMap to keep track of number frequencies and a MaxHeap (PriorityQueue)
 * to store the top k elements based on its frequency.
 * 3/26/2024 Winston Tsui
*/

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequencies
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        // Perform bucket sort where the index is the item's frequency
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (buckets[entry.getValue()] == null)
                buckets[entry.getValue()] = new ArrayList<>();
            buckets[entry.getValue()].add(entry.getKey());
        }

        // Collect the top k elements
        List<Integer> ans = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && ans.size() < k; i--)
            if (buckets[i] != null)
                ans.addAll(buckets[i]);

        return ans.stream().mapToInt(i -> i).toArray();
    }
}

// // Heap Approach:
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         int[] ans = new int[k];
//         // HashMap<Element, [Element, freq]>
//         HashMap<Integer, Integer[]> freq = new HashMap<>();
//         for (int i : nums) {
//             if (!freq.containsKey(i))
//                 freq.put(i, new Integer[] { i, 1 });
//             else
//                 freq.get(i)[1] += 1;
//         }

//         // Stores top K frequent elements in a maxheap
//         PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

//         for (Integer[] currFreq : freq.values()) {
//             if (k > -1)
//                 maxHeap.add(currFreq);
//             else {
//                 maxHeap.remove();
//                 maxHeap.add(currFreq);
//             }
//         }
//         for (int i = 0; i < ans.length; i++)
//             ans[i] = maxHeap.remove()[0];
//         return ans;
//     }
// }

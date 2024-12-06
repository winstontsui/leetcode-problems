/*
 * Leetcode 3346: Maximum Frequency of an Element After Performing Operations I. Java. Medium.
 * O(n log n) runtime and O(n) space complexity, where n is the length of the array.
 * Use a line sweep algorithm with a TreeMap to track the influence ranges of each element in nums after applying the operations.
 * A frequency map is used to count occurrences of each element, and the TreeMap helps compute the maximum possible frequency of any number efficiently.
 * This approach handles large inputs effectively by leveraging sorted keys and cumulative sums.
 * 12/6/2024 Winston Tsui
 */

import java.util.HashMap;
import java.util.TreeMap;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        // nums = [0,11,16,20], k = 5, numOperations = 3

        // Treemap
        // 0:1, 11:-1, 6:1, 17:-1, 15:1, 15:1, 26:-1;

        // HashMap to store frequencies of elements in nums.

        int maxFreq = 0;
        HashMap<Integer, Integer> frequency = new HashMap<>();
        TreeMap<Integer, Integer> linesweep = new TreeMap<>();

        for (int num : nums){
            frequency.put(num, frequency.getOrDefault(num, 0)+1);
            linesweep.putIfAbsent(num, 0);
            linesweep.put(num-k, linesweep.getOrDefault(num-k, 0)+1);
            linesweep.put(num+k+1, linesweep.getOrDefault(num+k+1, 0)-1);
        }

        int sum = 0;
        for (var entry : linesweep.entrySet()){
            sum += entry.getValue();
            maxFreq = Math.max(maxFreq, Math.min(sum, frequency.getOrDefault(entry.getKey(), 0) + numOperations));
        }
        return maxFreq;
    }
}

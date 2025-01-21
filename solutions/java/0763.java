/*
 * Leetcode 763: Partition Labels. Java. Medium.
 * O(n) runtime and O(1) space complexity (26 letters in the English alphabet).
 * Uses a greedy approach with a last-occurrence map to partition the string such that
 * each character appears in at most one partition. Dynamically tracks the end of the 
 * current partition and calculates its size as the string is traversed.
 * Insights: The partition boundary is determined by the farthest index any character
 * in the current segment extends to.
 * 1/21/2025
 */

import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> partitions = new ArrayList<>();
        HashMap<Character, Integer> lastOccurance = new HashMap<>();
        int end = 0;
        int size = 0;

        for (int i = 0; i < s.length(); i++)
            lastOccurance.put(s.charAt(i), i);

        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastOccurance.get(s.charAt(i)));
            if (end == i) {
                // End of partition
                partitions.add(size);
                size = 0;
            }

        }
        return partitions;
    }
}

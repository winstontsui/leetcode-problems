/*
 * Leetcode 1207: Unique Number of Occurrences. Java. Easy.
 * O(n) runtime and O(n) space complexity.
 * Store frequencies of numbers in a HashMap and put values in a HashSet. 
 * If there are duplicates, there are unique occurrences, so return false.
 * 7/12/2024 Winston Tsui
 */

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> numOccurrences = new HashMap<>();
        for (int i : arr)
            numOccurrences.put(i, numOccurrences.getOrDefault(i, 0) + 1);

        HashSet<Integer> unique = new HashSet<>();
        for (Integer i : numOccurrences.keySet()) {
            if (unique.contains(numOccurrences.get(i)))
                return false;
            unique.add(numOccurrences.get(i));
        }
        return true;
    }
}

/*
 * Leetcode 767: Reorganize String. Java. Medium.
 * O(n log k) runtime and O(n) space complexity.
 * Greedy algorithm using a max heap (PriorityQueue) to construct a valid arrangement of characters
 * where no two adjacent characters are the same. Returns "" if such an arrangement is impossible.
 * 11/14/2024 Winston Tsui
 */

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public String reorganizeString(String s) {
        // Counts frequency of lowercase english characters.
        int[] freqMap = new int[26];

        int mostFreq = 0;
        for (char c : s.toCharArray()) {
            freqMap[c - 'a'] += 1;
            if (mostFreq < freqMap[c - 'a'])
                mostFreq = freqMap[c - 'a'];
        }

        // If the most frequent character is more than half the length of s, return ""
        if (mostFreq > (s.length() + 1) / 2)
            return "";

        // Add elements to max heap based on frequency.
        Queue<Integer[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freqMap[i] != 0)
                heap.add(new Integer[] { i, freqMap[i] });
        }

        StringBuilder possibleStr = new StringBuilder();

        // Construct possible string arrangement by choosing two characters at a time.
        while (heap.size() > 1) {
            Integer[] first = heap.remove();
            Integer[] second = heap.remove();

            possibleStr.append((char) (first[0] + 'a'));
            possibleStr.append((char) (second[0] + 'a'));

            first[1]--;
            second[1]--;

            if (first[1] != 0)
                heap.add(first);

            if (second[1] != 0)
                heap.add(second);

        }

        if (!heap.isEmpty()) {
            possibleStr.append((char) (heap.remove()[0] + 'a'));
        }

        return possibleStr.toString();
    }
}

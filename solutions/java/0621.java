/*
 * LeetCode 621: Task Scheduler. Java. Medium.
 * O(n) time complexity for counting tasks and calculating intervals.
 * O(1) space complexity for storing task frequencies (fixed size of 26).
 * The solution uses a greedy approach to space out the most frequent tasks with a minimum number of intervals.
 * Calculates minimum intervals as (f_max - 1) * (n + 1) + maxCount, where f_max is the highest frequency of any task.
 * If the calculated intervals are less than the total number of tasks, return the task count as no idle time is needed.
 * 11/2/2024 Winston Tsui
 */

import java.util.HashMap;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // tasks = [A, A, A, A, B, B, B, B], n = 3

        // A B i i A B i i A B i i   A B
        // 3 * n+1 + 2
        // 3 things here: 1) freq of most freq character - 1, 2) n, 3) # occurances of most freq char
        // 13

        // Step 1: Count frequency of each task
        HashMap<Character, Integer> charFreq = new HashMap<>(); // This can be int[26]
        for (Character task : tasks)
            charFreq.put(task, charFreq.getOrDefault(task, 0) + 1);

        // Step 2: Find the task with the maximum frequency
        int maxFreq = 0;
        for (Character c : charFreq.keySet())
            if (charFreq.get(c) > maxFreq)
                maxFreq = charFreq.get(c);

        // Step 3: Count how many tasks have the maximum frequency
        int maxFreqOccurances = 0;
        for (Character c : charFreq.keySet())
            if (charFreq.get(c) == maxFreq)
                maxFreqOccurances++;

        // The minimum amount of intervals required must be at least tasks.length in all circumstances.
        int minInterval = (maxFreq - 1) * (n + 1) + maxFreqOccurances;
        return Math.max(minInterval, tasks.length);

    }
}

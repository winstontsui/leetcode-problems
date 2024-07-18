/*
 * Leetcode 752: Open the Lock. Java. Medium.
 * O(10^4) runtime and O(10^4) space complexity.
 * Perform a BFS starting from the initial lock "0000", keeping track of the number of steps until we reach target.
 * Skip deadend and previously visited combinations by checking our HashSet.
 * 7/18/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadendAndVisited = new HashSet<>();
        int steps = 0;
        for (String deadend : deadends)
            deadendAndVisited.add(deadend);

        Queue<String> deque = new ArrayDeque<>();
        deque.add("0000");

        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                String currentCombination = deque.remove();
                if (currentCombination.equals(target))
                    return steps;
                if (deadendAndVisited.contains(currentCombination))
                    continue;
                // Add to deque-- each digit added and subtracted by one, for a total of 8.
                for (int i = 0; i < 4; i++) {
                    int digit = Character.getNumericValue(currentCombination.charAt(i));
                    deque.add(currentCombination.substring(0, i) + (digit + 1) % 10
                            + currentCombination.substring(i + 1, 4));
                    deque.add(currentCombination.substring(0, i) + (digit - 1 + 10) % 10
                            + currentCombination.substring(i + 1, 4));
                }
                deadendAndVisited.add(currentCombination);
            }
            steps++;
        }
        return -1;
    }
}

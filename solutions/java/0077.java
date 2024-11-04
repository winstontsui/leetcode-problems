/*
 * Leetcode 77: Combinations. Java. Medium.
 * O(n choose k) * O(k) time complexity due to generating each combination of k numbers from n.
 * Uses backtracking to explore all combinations of k elements from numbers in range [1, n].
 * Each recursive call either includes or excludes the current element.
 * 11/4/2024 Winston Tsui
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(n, k, 1, answer, new ArrayList<>());
        return answer;
    }

    private void backtrack(int n, int k, int i, List<List<Integer>> answer, List<Integer> curr) {
        // Base case: If we chose k numbers already, we have found a possible combination! Add it.
        if (k == 0) {
            answer.add(new ArrayList<Integer>(curr));
            return;
        }

        // Base case: If this combination exceeds n, return as no more combinations can be formed
        if (i > n)
            return;

        // 2 Choices: Add current number or don't.
        curr.add(i);
        backtrack(n, k - 1, i + 1, answer, curr);
        curr.remove(curr.size() - 1); // Backtrack: remove the last added number to explore other combinations

        backtrack(n, k, i + 1, answer, curr);

    }
}

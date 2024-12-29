/*
 * Leetcode 39: Combination Sum. Java. Medium.
 * O(2^t) runtime and O(t) space complexity, where t = target / minimum candidate.
 * This solution uses backtracking to find all unique combinations of candidates that sum up to a target.
 * Candidates can be reused multiple times in each combination. The algorithm explores all possible paths, adding valid combinations to the result.
 * Insights: Recursive exploration ensures all valid combinations are generated while pruning invalid paths early when the target becomes negative.
 * 12/29/2024 Winston Tsui
 */

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int[] candidates, int target, int idx, List<Integer> curr) {
        if (target < 0)
            return;
        // Valid combination found
        if (target == 0)
            ans.add(new ArrayList<>(curr));

        for (int i = idx; i < candidates.length; i++) {
            // Include the current candidate in the combination
            curr.add(candidates[i]);

            // Recursively explore with the reduced target, allowing reuse of candidate
            backtrack(ans, candidates, target - candidates[i], i, curr);

            // Backtrack: remove the last added element to explore other combinations
            curr.remove(curr.size() - 1);
        }
    }
}

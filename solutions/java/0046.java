/*
 * Leetcode 46: Permutations. Java. Medium.
 * O(N × N!) runtime and O(N!) space complexity.
 * Uses backtracking to explore all possible permutations by recursively building lists of unused elements.
 * A boolean array tracks which elements are in use to avoid duplicates.
 *
 * Input: nums = [1, 2, 3]
 * Step-by-step example:
 *  → Start with [], choose 1 → [1]
 *     → choose 2 → [1, 2]
 *       → choose 3 → [1, 2, 3] add to result
 *       → backtrack → [1, 2] → try 3 then 2 ...
 *  Final output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
 *
 * 4/21/2025 Winston Tsui
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, nums, new boolean[nums.length], new ArrayList<>());
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int[] nums, boolean[] used, ArrayList<Integer> curr) {
        if (curr.size() == nums.length) 
            ans.add(new ArrayList<>(curr));

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            curr.add(nums[i]);
            backtrack(ans, nums, used, curr);
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}

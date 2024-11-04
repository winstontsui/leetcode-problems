/*
 * Leetcode 78: Subsets. Java. Medium.
 * Backtracking algorithm. O(n * 2^n) runtime and O(n * 2^n) space complexity.
 * For runtime, at every step, I decide whether or not to include nums[i]. Two choices.
 * Use a backtracking algorithm to try every possible combination of numbers in nums.
 * Store the current combination of numbers in path.
 * 2/26/2024 Winston Tsui
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        tryPosition(nums, 0, path, ans);
        return ans;
    }

    private void tryPosition(int[] nums, int startingPoint, List<Integer> path, List<List<Integer>> ans) {
        // Add a copy of the current path! Path will change over time.
        ans.add(new ArrayList<>(path));

        for (; startingPoint < nums.length; startingPoint++) {
            path.add(nums[startingPoint]);
            tryPosition(nums, startingPoint + 1, path, ans);
            // If I remove nums[startingPoint], it will remove its first occurance.
            // However, I want to remove the last occurance!
            path.remove(path.size() - 1);
        }
    }
}

// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> answer = new ArrayList<>();
//         backtrack(nums, 0, new ArrayList<>(), answer);
//         return answer;
//     }

//     private void backtrack(int[] nums, int index, List<Integer> curr, List<List<Integer>> answer) {
//         if (index == nums.length) {
//             List<Integer> ans = new ArrayList<>();
//             for (Integer i : curr)
//                 ans.add(i);
//             answer.add(ans);
//             return;
//         }
//         // 2 choices: Include current character or don't.
//         backtrack(nums, index + 1, curr, answer);

//         curr.add(nums[index]);
//         backtrack(nums, index + 1, curr, answer);
//         curr.remove(curr.size() - 1);
//     }
// }

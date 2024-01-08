/*
 * Leetcode 128: Longest Consecutive Sequence. Java. Medium.
 * Clever HashSet and Array problem. O(n) runtime and O(n) space complexity.
 * Put nums in a hashset for O(1) searching later. The trick is to know when I reach the end of a sequence,
 * which is when number+1 is not in hashset. Count the length of the sequence. Update final answer accordingly.
 * 1/7/2024 Winston Tsui
*/

import java.util.HashSet;

class Solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        HashSet<Integer> arr = new HashSet<Integer>();
        int ans = 1;

        for (int num : nums)
            arr.add(num);

        for (int num : nums) {
            // This makes this solution O(n): I only compute the length of the sequence at its end. In the worst case, I only go through every element twice.
            if (arr.contains(num + 1))
                continue;
            int count = 1;
            while (arr.contains(--num)) 
                count++;
            // I can also do Math.max(ans, count)
            ans = (count > ans) ? count : ans;

        }
        return ans;
    }
}
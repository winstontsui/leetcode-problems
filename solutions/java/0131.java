/*
 * Leetcode 131: Palindrome Partitioning. Java. Medium.
 * O(n * 2^n) runtime and O(n) space complexity.
 * This solution uses backtracking to generate all possible partitions of the string `s` and checks for palindromes to build valid partitions.
 * For each substring, it uses a helper function to determine if it is a palindrome and recursively explores further partitions.
 * Insights: The key is to use a combination of substring exploration and backtracking to efficiently generate and validate partitions.
 * 12/27/2024 Winston Tsui
 */

import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partition(ans, s, 0, new ArrayList<>());
        return ans;
    }

    private void partition(List<List<String>> ans, String s, int start, List<String> curr) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(curr)); // Add the current partition to the result
            return;
        }

        // Iterate through all possible substrings starting from 'start'
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                curr.add(s.substring(start, end + 1));
                partition(ans, s, end + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end)
            if (str.charAt(start++) != str.charAt(end--))
                return false;

        return true;
    }
}

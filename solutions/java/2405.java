/*
 * Leetcode 2405: Optimal Partition of String. Java. Medium.
 * O(n) runtime and O(1) space complexity.
 * Use an array to store characters in the current substring and if a duplicate is
 * detected, add to ans and reset entire array.
 * 8/5/2024 Winston Tsui
*/

class Solution {
    public int partitionString(String s) {
        int[] chars = new int[26];
        int ans = 1; // We start with 1 substring

        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] != 0) {
                chars = new int[26];
                ans++;
            }
            chars[s.charAt(i) - 'a']++;
        }
        return ans;
    }
}


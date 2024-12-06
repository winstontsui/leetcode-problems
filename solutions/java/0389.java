/*
 * Leetcode 389: Find the Difference. Java. Easy.
 * O(n) runtime and O(1) space complexity, where n is the length of the longer string.
 * Use a frequency count array to track occurrences of each character.
 * The first character in the second string (`t`) with an unmatched count is identified as the extra character.
 * 12/6/2024 Winston Tsui
 */

class Solution {
    public char findTheDifference(String s, String t) {
        int[] vocab = new int[26];

        // Count characters in string s
        for (Character c : s.toCharArray())
            vocab[c - 'a']++;

        // Subtract counts for characters in string t
        for (Character c : t.toCharArray()) {
            vocab[c - 'a']--;
            if (vocab[c - 'a']-- == -1)
                return c;
        }

        // Default case, should not happen
        return ' ';
    }
}

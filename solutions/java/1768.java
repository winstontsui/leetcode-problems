/*
 * Leetcode 1768: Merge Strings Alternately. Java. Easy.
 * O(n + m) runtime and O(n + m) space complexity, where n and m are the lengths of word1 and word2.
 * Use two pointers to alternately merge characters from both words. 
 * Any remaining characters from the longer word are appended to the result.
 * This approach efficiently combines both strings with a single traversal of their characters.
 * 12/4/2024 Winston Tsui
 */

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        // Pointers for both words
        int i = 0, j = 0;

        // Alternate merging
        while (i < word1.length() && j < word2.length()) {
            merged.append(word1.charAt(i++));
            merged.append(word2.charAt(j++));
        }

        // Append remaining characters from word1 or word2
        while (i < word1.length())
            merged.append(word1.charAt(i++));
        while (j < word2.length())
            merged.append(word2.charAt(j++));

        return merged.toString();
    }
}

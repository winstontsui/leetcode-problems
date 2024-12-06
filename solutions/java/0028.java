/*
 * Leetcode 28: Find the Index of the First Occurrence in a String. Java. Easy.
 * O(h * n) runtime and O(1) space complexity, where h is the length of the haystack
 * and n is the length of the needle.
 * This solution implements a brute-force substring search by iterating through all
 * possible starting positions in the haystack and comparing the needle character by character.
 * 12/6/2024 Winston Tsui
 */

class Solution {
    public int strStr(String haystack, String needle) {

        // Iterate over each possible starting position in haystack
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            // Check if needle matches at this starting position
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
                if (j == needle.length() - 1)
                    return i;
            }
        }
        return -1; // If no match is found.
    }
}

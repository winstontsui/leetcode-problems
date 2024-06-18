/*
 * Leetcode 383: Ransom Note. Java. Easy.
 * O(n) runtime and O(1) space complexity.
 * Create a simple int[26] hashmap that maps each lowercase char to its frequency. 
 * Update frequency values based on magazine and subtract frequency values based on ransomNote.
 * 6/18/2024 Winston Tsui
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] characters = new int[26];
        for (char c : magazine.toCharArray())
            characters[c - 'a']++;

        for (char c : ransomNote.toCharArray())
            if (--characters[c - 'a'] < 0)
                return false;

        return true;
    }
}

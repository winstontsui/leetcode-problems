/*
 * Leetcode 242: Valid Anagram. Java. Easy.
 * O(n) runtime and O(1) space complexity, where n is the length of the strings.
 * Use a frequency count array of size 26 to track the occurrences
 * of each character in both strings. Increment counts for one string and decrement the other. 
 * If all counts are zero at the end, the strings are anagrams.
 * 11/24/2024 Winston Tsui
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] mapping = new int[26];
        if (s.length() != t.length())
            return false;
            
        for (int i = 0; i < t.length(); i++){
            mapping[t.charAt(i) - 'a']++;
            mapping[s.charAt(i) - 'a']--;
        }

        for (int i = 0; i < mapping.length; i++){
            if (mapping[i] != 0)
                return false;
        }
        return true;
    }
}

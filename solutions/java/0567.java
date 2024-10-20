/*
 * Leetcode 567: Permutation in String. Java. Medium.
 * O(n) runtime and O(1) space complexity.
 * Create a constant-sized, moving window. Use int[26] array to store freq of characters.
 * Subtract/add this array traversing through s2. If everything is 0, s2 contains a permutation of s1.
 * 6/10/2024 Winston Tsui
 */

 class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] chars = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }

        // Go one character at a time starting from s1.length.
        for (int i = s1.length(); i < s2.length() + 1; i++) {
            // Checks if everything in chars is 0.
            for (int num = 0; num < chars.length; num++) {
                if (chars[num] != 0)
                    break;
                if (num == 25)
                    return true;
            }

            // Increment char @index i count and decrement char @(i-s1.length) count.
            if (i != s2.length()) {
                chars[s2.charAt(i - s1.length()) - 'a']++;
                chars[s2.charAt(i) - 'a']--;
            }
        }
        return false;
    }
}

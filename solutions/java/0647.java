/*
 * Leetcode 647: Palindromic Substrings. Java. Medium.
 * O(N²) runtime and O(1) space complexity.
 * Uses the Expand Around Center approach to efficiently count all palindromic substrings.
 * Each character and each adjacent pair is treated as a potential palindrome center.
 * Expand outward while maintaining a valid palindrome condition.
 * 1/25/2025 Winston Tsui
*/


class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            count += palindromeCount(s, i, i);
            count += palindromeCount(s, i, i+1);
        }

        return count;
    }

    private int palindromeCount(String s, int l, int r){
        int count = 0;
        while (l > -1 && r < s.length() && s.charAt(l) == s.charAt(r)){
            count++;
            l--;
            r++;
        }
        return count;
    }
}

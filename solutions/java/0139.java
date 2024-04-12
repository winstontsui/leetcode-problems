/*
 * Leetcode 139: Word Break. Java. Medium.
 * O(n*m*k) runtime and O(n) space complexity, where m is wordDict.length and k is average length of words.
 * Dynamic Programming problem where I create a boolean[] canBreak array. Start from back of s.
 * If a word w in wordDict doesn't go out of bounds, matches s from index i to i+w.length(), 
 * and canBreak[i+w.length()] is segmentable, mark canBreak[i] as segmentable.
 * 4/12/2024 Winston Tsui
*/

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[canBreak.length - 1] = true;

        for (int i = s.length() - 1; i > -1; i--) {
            for (String w : wordDict) {
                // First condition checks for out of bounds error.
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)
                        && canBreak[i + w.length()]) {
                    canBreak[i] = true;
                    break; // We found a word making canBreak[i] true, so continue down s.
                }
            }
        }
        return canBreak[0];
    }
}

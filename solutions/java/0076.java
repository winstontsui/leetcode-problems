/*
 * Leetcode 76: Minimum Window Substring. Java. Hard.
 * O(|s| + |t|) runtime and O(|s| + |t|) space complexity.
 * Uses a sliding window approach with two frequency maps to dynamically expand
 * and contract the window. Ensures all characters from t are included in the 
 * current window before trying to shrink it. Efficiently tracks the minimum 
 * window size during the process.
 * 1/20/2025
 */

import java.util.*;

class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> tChars = new HashMap<>(); // Maps character to its frequency in t
        HashMap<Character, Integer> windowChars = new HashMap<>(); // Maps character to its frequency in window
        int have = 0;
        int need = t.length();

        for (char c : t.toCharArray())
            tChars.put(c, tChars.getOrDefault(c, 0) + 1);

        int[] ans = { -1, -1 }; // [left, right]
        int minLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            // Update window
            windowChars.put(c, windowChars.getOrDefault(c, 0) + 1);

            if (tChars.containsKey(c) && windowChars.get(c) <= tChars.get(c))
                have++;

            while (have == need) {
                if (r - l + 1 < minLen) {
                    ans[0] = l;
                    ans[1] = r;
                    minLen = r - l + 1;
                }

                // Remove left character from window
                char leftChar = s.charAt(l);
                windowChars.put(leftChar, windowChars.get(leftChar) - 1);
                if (tChars.containsKey(leftChar) && windowChars.get(leftChar) < tChars.get(leftChar))
                    have--;

                l++;
            }

        }
        return ans[0] == -1 ? "" : s.substring(ans[0], ans[1] + 1);
    }
}

/*
 * Leetcode 424: Longest Repeating Character Replacement. Java. Medium.
 * One of the nastiest problems I've ever seen. O(n) runtime and O(1) spacetime.
 * Keep characters in current window in count HashMap and continously check to see if the current
 * window is valid, if it is, update variable longest. How do I check that the window is valid?
 * If the number of possible replacements (which is k) is not enough for the number of characters 
 * we can replace the string with, keep removing character at position l++ until it doesn't.
 * 2/3/2024 Winston Tsui
*/

import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int longest = 0;
        // A count[26] array also suffices.
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();

        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);

            // while (current window is not valid), remove character at position l.
            while (r - l + 1 - Collections.max(count.values()) > k)
                count.put(s.charAt(l), count.get(s.charAt(l++)) - 1);

            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}

// class Solution {
//     public int characterReplacement(String s, int k) {
//         // HashMap to track characters and their frequency in window.
//         HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
//         int maxCurrCount = 0; // Most frequent number of occurances for a character.
//         int maxLen = 0;
//         int l = 0;

//         for (int r = 0; r < s.length(); r++){
//             map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
//             maxCurrCount = Math.max(maxCurrCount, map.get(s.charAt(r)));
            
//             // Shrink window from the left as necessary.
//             while (r - l + 1 - maxCurrCount > k){
//                 map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
//                 l++;
//             }
//             maxLen = Math.max(maxLen, r - l + 1);
//         }
//         return maxLen;
//     }
// }

/*
 * Leetcode 13: Design Twitter. Java. Easy.
 * O(n) runtime and O(1) space complexity.
 * Tricky problem. Store Roman numerals and their corresponding values in a HashMap.
 * Iterate through s. If char c is used to subtract, make it negative. Keep adding c to ans.
 * 6/14/2024 Winston Tsui
 */

import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            if (i < s.length()-1 && values.get(s.charAt(i+1)) > values.get(s.charAt(i)))
                ans -= values.get(s.charAt(i));
            else
                ans += values.get(s.charAt(i));
        }

        // // s is guaranteed to be a valid Roman numeral, so all I have to check is if the next symbol is larger than the current one.
        // for (int i = 0; i < s.length(); i++) {
        //     switch (s.charAt(i)) {
        //         case 'I':
        //             if (i < s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X'))
        //                 ans += values.get(s.charAt(i + 1)) - values.get(s.charAt(i++));
        //             else
        //                 ans += values.get(s.charAt(i));
        //             break;
        //         case 'X':
        //             if (i < s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'))
        //                 ans += values.get(s.charAt(i + 1)) - values.get(s.charAt(i++));
        //             else
        //                 ans += values.get(s.charAt(i));
        //             break;
        //         case 'C':
        //             if (i < s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M'))
        //                 ans += values.get(s.charAt(i + 1)) - values.get(s.charAt(i++));
        //             else
        //                 ans += values.get(s.charAt(i));
        //             break;
        //         default:
        //             ans += values.get(s.charAt(i));

        //     }
        // }
        
        return ans;
    }
}

/*
 * Leetcode 17: Letter Combinations of a Phone Number. Java. Medium.
 * O(3^m * 4^n) time complexity, where m is the number of digits mapping to 3 letters and n maps to 4.
 * Uses backtracking to generate all possible letter combinations for the provided digits.
 * A map of digit-to-letter arrays allows efficient lookup, and a StringBuilder dynamically builds each combination.
 * 11/4/2024 Winston Tsui
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<String>();
        if (digits == null || digits.length() == 0)
            return ans;

        Map<Character, char[]> digitsToLettersMap = Map.of('2', new char[] { 'a', 'b', 'c' }, '3',
                new char[] { 'd', 'e', 'f' }, '4', new char[] { 'g', 'h', 'i' }, '5', new char[] { 'j', 'k', 'l' }, '6',
                new char[] { 'm', 'n', 'o' }, '7', new char[] { 'p', 'q', 'r', 's' }, '8', new char[] { 't', 'u', 'v' },
                '9', new char[] { 'w', 'x', 'y', 'z' });

        backtrack(digits, 0, new StringBuilder(), ans, digitsToLettersMap);
        return ans;
    }

    private void backtrack(String digits, int index, StringBuilder currString, List<String> ans,
            Map<Character, char[]> digitsToLettersMap) {
        // Base case: We found a string of length digits.length.
        if (index == digits.length()) {
            ans.add(currString.toString());
            return;
        }

        if (index > digits.length())
            return;

        for (char c : digitsToLettersMap.get(digits.charAt(index))) {
            // 2 options: Include this character or not. For loop implicitly includes case
            // where character isn't included.
            currString.append(c);
            backtrack(digits, index + 1, currString, ans, digitsToLettersMap);
            currString.deleteCharAt(currString.length() - 1);
        }

    }
}

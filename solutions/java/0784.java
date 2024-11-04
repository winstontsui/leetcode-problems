/*
 * Leetcode 784: Letter Case Permutation. Java. Medium.
 * O(2^n * n) time complexity, where n is the number of letters in the input string.
 * Uses backtracking to explore both uppercase and lowercase options for each letter.
 * Digits remain unchanged, and each path forms a valid permutation.
 * Recursively build and add each permutation to the result list.
 * 11/2/2024 Winston Tsui
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> answer = new ArrayList<>();
        backtrack(s, new ArrayList<>(), answer, 0);
        return answer;
    }

    private void backtrack(String s, List<Character> currString, List<String> answer, int index) {
        if (index == s.length()) {
            // Convert the current character list to a string and add to answer
            StringBuilder ans = new StringBuilder();
            for (Character c : currString)
                ans.append(c);
            answer.add(ans.toString());
            return;
        }

        // If the character is a letter, explore both uppercase and lowercase options.
        if (Character.isLetter(s.charAt(index))) {
            // Add the uppercase letter, recurse and backtrack.
            currString.add(Character.toUpperCase(s.charAt(index)));
            backtrack(s, currString, answer, index + 1);
            currString.remove(currString.size() - 1);

            // Add the lowercase letter, recurse and backtrack.
            currString.add(Character.toLowerCase(s.charAt(index)));
            backtrack(s, currString, answer, index + 1);
            currString.remove(currString.size() - 1);
        } else {
            // If it's a digit, just add it as-is.
            currString.add(s.charAt(index));
            backtrack(s, currString, answer, index + 1);
            currString.remove(currString.size() - 1);
        }
    }
}

/*
 * Leetcode 472: Concatenated Words. Java. Hard.
 * O(N * L^2) runtime and O(N*L) space complexity.
 * Nightmares. Use dp to check at each point if there are substrings, using a HashSet for efficient substring lookups. 
 * Temporarily remove each word from HashSet, using boolean array to track valid concatenations and add to ans if word is a concatenated word.
 * 6/25/2024 Winston Tsui
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        List<String> ans = new ArrayList<>();
        for (String word : words)
            wordSet.add(word);

        for (String word : words) {
            // See if we can concatenate items in wordSet to make the current word.
            wordSet.remove(word);
            boolean[] canConcatenate = new boolean[word.length() + 1]; // Because substring() goes up to word.length()+1.
            canConcatenate[0] = true;

            for (int i = 0; i < word.length(); i++) {
                // If the current prefix cannot be formed, there's no point in checking for
                // words.
                if (!canConcatenate[i])
                    continue;

                for (int j = i + 1; j < word.length() + 1; j++)
                    if (wordSet.contains(word.substring(i, j)) && canConcatenate[i] == true)
                        canConcatenate[j] = true;

            }

            if (canConcatenate[canConcatenate.length - 1] == true)
                ans.add(word);

            wordSet.add(word);
        }
        return ans;
    }
}

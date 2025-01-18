/*
 * Leetcode 49: Group Anagrams. Java. Medium.
 * O(n*m) runtime and O(n*m) space complexity, where n is len of strs and m is 
 * the len of every word. The idea is to count the frequency of characters in 
 * every word and store "related" words as a string. I use a HashMap to group 
 * these words together.
 * 2/8/2024 Winston Tsui
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // {"11100 ... 0000" -> {{"abc"}, {"cba"}, {"bca"}}}
        HashMap<String, List<String>> words = new HashMap<>();

        for (String s : strs) {
            char[] hashCode = new char[26];
            for (char c : s.toCharArray())
                hashCode[c - 'a'] += 1;

            StringBuilder encoded = new StringBuilder();
            for (char c : hashCode)
                encoded.append(c);
            String encodedWord = encoded.toString();

            if (words.containsKey(encodedWord))
                words.get(encodedWord).add(s);
            else {
                ArrayList<String> pattern = new ArrayList<>();
                pattern.add(s);
                words.put(encodedWord, pattern);
            }
        }

        return new ArrayList<>(words.values());
    }
}

/*
 * LeetCode 648: Replace Words. Java. Medium.
 * O(k * m + n * l) time complexity, O(k * m) space complexity,
 * where k is the number of roots in the dictionary, m is the max length of a root, 
 * n is the number of words in the sentence, and l is the maximum length of a word.
 * 
 * A Trie is necessary because it allows efficient prefix matching:
 * it enables us to find the shortest root for each word in the sentence by stopping at the earliest
 * match, rather than iterating through every root in the dictionary.
 * 11/9/2024 Winston Tsui
 */

import java.util.HashMap;
import java.util.List;

class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // Put all words in dictionary in trie data structure.
        TrieNode root = new TrieNode();
        buildTrie(root, dictionary);
        // For all words in sentence, determine if it is possible to shorten it based on trie.
        String[] sentenceSplit = sentence.split(" ");
        StringBuilder ans = new StringBuilder();

        // Replace words in sentence with derivatives in Trie if possible.
        for (String s : sentenceSplit) {
            ans.append(searchTrie(root, s)).append(" ");
        }
        return ans.toString().trim();
    }

    // Inserts all dictionary words in trie.
    private void buildTrie(TrieNode root, List<String> dictionary) {
        for (String s : dictionary) {
            TrieNode curr = root;
            for (Character c : s.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.endOfWord = true;
        }
    }

    // Determines if derivative is possible, otherwise return original word.
    private String searchTrie(TrieNode root, String s) {
        TrieNode curr = root;
        StringBuilder possibleDerivative = new StringBuilder();
        for (Character c : s.toCharArray()) {
            // If theres no possible derivative, return orignal word.
            if (!curr.children.containsKey(c)) {
                return s;
            } else {
                possibleDerivative.append(c);
                curr = curr.children.get(c);
                // If there is a derivative, return it.
                if (curr.endOfWord)
                    return possibleDerivative.toString();
            }
        }
        return s;
    }
}

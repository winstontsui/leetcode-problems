/*
 * LeetCode 208: Implement Trie (Prefix Tree). Java. Medium.
 * O(m) time complexity for insert, search, and startsWith, where m is the length of the word or prefix.
 * Uses a Trie data structure with a HashMap to store child nodes. Nodes are characters in a string.
 * It's called a prefix tree because prefixes can be checked very efficiently, in O(1) time. 
 * Otherwise a HashMap is really good for inserting and checking!
 * 11/8/2024 Winston Tsui
 */

import java.util.HashMap;

class TrieNode {
    // Instance variables for TrieNode
    // An alternative is to use a TrieNode[26] for children because they are all
    // lowercase characters.
    HashMap<Character, TrieNode> children; // {{'a', TrieNode}}
    boolean endOfWord;

    public TrieNode() {
        // I don't store the current character here, it is implicit when accessing the
        // children HashMap because it's the key.
        children = new HashMap<>();
        endOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for (Character c : word.toCharArray()) {
            // If character is not present in the children map, add it
            temp.children.putIfAbsent(c, new TrieNode());

            // Move to the child node
            temp = temp.children.get(c);
        }
        // Mark the end of the word
        temp.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for (Character c : word.toCharArray()) {
            if (temp.children.containsKey(c))
                temp = temp.children.get(c);
            else
                return false; // If character is not found in the children map, the prefix does not exist
        }
        return temp.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (Character c : prefix.toCharArray()) {
            if (temp.children.containsKey(c))
                temp = temp.children.get(c);
            else
                return false; // If character is not found in the children map, the prefix does not exist
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

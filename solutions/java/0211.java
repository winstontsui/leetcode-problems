/*
 * Leetcode 211: Design Add and Search Words Data Structure. Java. Medium.
 * O(N) runtime for insertion and exact searches, worst-case O(26^N) for wildcard searches.
 * Implements a Trie (Prefix Tree) for efficient word storage and retrieval.
 * Uses Depth-First Search (DFS) to handle wildcard (`"."`) searches by exploring multiple possible paths.
 * Key Insight: A Trie allows fast word lookup while efficiently handling wildcards through recursive DFS.
 * 2/17/2025 Winston Tsui
*/

class WordDictionary {
    Trie trie;

    static class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd;
    }

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        Trie curr = trie;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new Trie();
            curr = curr.children[c - 'a'];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, trie);
    }

    private boolean dfs(String word, int idx, Trie curr) {
        for (int i = idx; i < word.length(); i++) {
            int c = word.charAt(i);
            if (c == '.') {
                // Recursive portion
                for (int j = 0; j < 26; j++) {
                    if (curr.children[j] != null && dfs(word, i + 1, curr.children[j]))
                        return true;
                }
                return false;
            } else {
                // Character does not exist in trie
                if (curr.children[c - 'a'] == null)
                    return false;
                curr = curr.children[c - 'a'];
            }
        }
        return curr.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

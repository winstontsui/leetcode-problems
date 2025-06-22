"""
 * Leetcode 269: Alien Dictionary. Python. Hard.
 * O(C) runtime, O(1) space complexity 
 * Topological sort with DFS to determine valid alien dictionary order.
 *
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Step 1: Build graph: {'t': {'f'}, 'w': {'e'}, 'r': {'t'}, 'e': {'r'}, 'f': set()}
 * Step 2: Topological sort: ['w', 'e', 'r', 't', 'f']
 * Result: "wertf"
 *
 * 6/22/2025 Winston Tsui
"""

from typing import List, Set, Dict

class Solution:
    """
    words = ["wrt","wrf","er","ett","rftt"]

    "wrt"
    "wrf"
    "er"
    "ett"
    "rftt"

    {t: f,
    w: e,
    r: t
    e: r
    f: set()
    }
    """

    def alienOrder(self, words: List[str]) -> str:
        map = {c : set() for w in words for c in w}
        ans = []
        visited = {} 

        for i in range(len(words)-1):
            word1, word2 = words[i], words[i+1]
            minLen = min(len(word1), len(word2))

            if (word1[:minLen] == word2[:minLen] and len(word1) > len(word2)):
                return ""
            for c1, c2 in zip(word1, word2):
                if (c1 != c2):
                    map[c1].add(c2)
                    break

        def dfs(c: str):
            if c in visited:
                return visited[c]
            visited[c] = True

            for nei in map[c]:
                if dfs(nei):
                    return True
                
            visited[c] = False
            ans.append(c)
            return False

        for c in map:
            if dfs(c):
                return ""
        ans.reverse()
        return "".join(ans)

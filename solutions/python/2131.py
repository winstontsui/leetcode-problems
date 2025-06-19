"""
 * Leetcode 2131: Longest Palindrome by Concatenating Two-Letter Words. Python. Medium.
 * O(N) runtime and O(N) space complexity
 * Freq map for word occurrences. Track if middle is used and the longest len palindrome.
 *
 * Input: words = ["lc","cl","gg"]
 * Step 1: Count frequencies: {"lc":1, "cl":1, "gg":1}
 * Step 2: Find mirrored pairs: "lc" + "cl" (length 4)
 * Step 3: Add "gg" as middle (length 2)
 * Result: 6 ("lc" + "gg" + "cl")
 *
 * 6/17/2025 Winston Tsui
"""

from collections import Counter
from typing import List

class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        freq = Counter(words)
        longest_palindrome = 0
        middle_used = False

        for word in list(freq.keys()):
            count = freq[word]
            reversed_word = word[::-1]
            
            if reversed_word == word:
                pairs = count // 2
                longest_palindrome += pairs * 4
                
                if count % 2 == 1 and not middle_used:
                    middle_used = True
                    longest_palindrome += 2
                    
            elif reversed_word in freq:
                pairs = min(count, freq[reversed_word])
                longest_palindrome += pairs * 4 
                
                freq[word] -= pairs
                freq[reversed_word] -= pairs

        return longest_palindrome

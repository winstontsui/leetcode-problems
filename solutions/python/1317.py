'''
 * Leetcode 1317: Convert Integer to the Sum of Two No-Zero Integers. Python. Easy.
 * O(N*d) runtime and O(1) space complexity. d is length of 
 * Iterates through possible values to find two numbers that sum to n and contain no zeros.
 *
 * Input: n = 1943
 * Step 1: Try a=1, b=1942 (n-a). None contain 0.
 * Step 2: Return [1, 1941]
 *
 * 6/14/2025 Winston Tsui
'''

class Solution:
    def getNoZeroIntegers(self, n: int) -> List[int]:
        for a in range(1, n):
            b = n - a
            if "0" not in str(a) and "0" not in str(b):
                return [a, b]

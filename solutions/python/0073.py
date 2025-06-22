"""
 * Leetcode 73: Set Matrix Zeroes. Python. Medium.
 * O(M*N) runtime and O(1) space complexity
 * Uses first row and column as markers, with special handling for first column.
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Step 1: Mark rows/cols to be zeroed using first row/col and firstColZero
 * Step 2: Zero out cells based on markers
 * Result: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * 6/22/2025 Winston Tsui
"""

from typing import List

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        firstColZero = False
        for r in range(len(matrix)):
            for c in range(len(matrix[0])):
                if matrix[r][c] == 0:
                    matrix[r][0] = 0
                    if c == 0:
                        firstColZero = True
                    else:
                        matrix[0][c] = 0

        for r in range(1, len(matrix)):
            for c in range(1, len(matrix[0])):
                if matrix[r][0] == 0 or matrix[0][c] == 0:
                    matrix[r][c] = 0

        if matrix[0][0] == 0:
            for c in range(len(matrix[0])):
                matrix[0][c] = 0

        if firstColZero:
            for r in range(len(matrix)):
                matrix[r][0] = 0

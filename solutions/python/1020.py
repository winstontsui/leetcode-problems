"""
 * Leetcode 1020: Number of Enclaves. Python. Medium.
 * O(M*N) runtime and O(1) space complexity
 * Uses BFS to mark boundary-connected land cells, then counts remaining land cells.
 *
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3 (three 1's not connected to the boundary)
 *
 * 6/28/2025 Winston Tsui
"""

from typing import List
from collections import deque as Deque

class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        # Mark these boundary cells as 0.
        def bfs(r, c):
            dq = Deque()
            dq.append((r, c))

            while dq:
                r, c = dq.popleft()
                grid[r][c] = 0

                for x, y in dirs: 
                    new_x = r + x
                    new_y = c + y
                    if 0 < new_x < rows-1 and 0 < new_y < cols-1 and grid[new_x][new_y] == 1:
                        grid[new_x][new_y] = 0
                        dq.append((new_x, new_y))

        for c in range(cols):
            if grid[0][c] == 1:
                bfs(0, c)
            if grid[rows-1][c] == 1:
                bfs(rows-1, c)

        for r in range(rows):
            if grid[r][0] == 1:
                bfs(r, 0)
            if grid[r][cols-1] == 1:
                bfs(r, cols-1)

        count = 0
        for r in range(1, rows-1):
            for c in range(1, cols-1):
                if grid[r][c] == 1:
                    count += 1
        return count

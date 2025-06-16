"""
 * Leetcode 1372: Longest ZigZag Path in a Binary Tree. Python. Medium.
 * O(N) runtime and O(H) space complexity where N is number of nodes and H is height of tree.
 * Uses DFS to track the longest zigzag path, alternating between left and right directions.
 *
 * 6/15/2025 Winston Tsui
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        self.longestlen = 0

        def dfs(node, direction, length) -> int:
            if not node: 
                return 0
                
            self.longestlen = max(self.longestlen, length)

            if direction == "left":
                dfs(node.left, "right", length + 1)
                dfs(node.right, "left", 1)
            else:
                dfs(node.right, "left", length + 1)
                dfs(node.left, "right", 1)
        
        dfs(root, "left", 0)
        dfs(root, "right", 0)
        
        return self.longestlen

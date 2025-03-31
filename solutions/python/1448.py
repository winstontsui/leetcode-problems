"""
Leetcode 1448: Count Good Nodes in Binary Tree. Python. Medium.
O(N) runtime and O(H) space complexity, where N is the number of nodes and H is the height of the tree.
DFS to traverse the tree while carrying the max value seen so far along the path.
3/30/2025 Winston Tsui
"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def numGoodNodes(root: TreeNode, maxSoFar: int) -> int:
            if not root:
                return 0
            count = 1 if root.val >= maxSoFar else 0
            maxSoFar = max(maxSoFar, root.val)
            count += numGoodNodes(root.left, maxSoFar)
            count += numGoodNodes(root.right, maxSoFar)
            return count

        return numGoodNodes(root, root.val)

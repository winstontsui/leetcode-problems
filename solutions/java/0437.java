import java.util.HashMap;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        // Maps current sum of a path to its frequency.
        HashMap<Long, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0L, 1);

        return pathSumHelper(root, 0L, targetSum, prefixSums);
    }

    private int pathSumHelper(TreeNode root, long currSum, int targetSum, HashMap<Long, Integer> prefixSums) {
        if (root == null)
            return 0;

        currSum += root.val;
        int count = 0;
        // Check if there's a sub-path that sums to the targetSum
        if (prefixSums.containsKey(currSum - targetSum)) {
            count += prefixSums.get(currSum - targetSum);
        }

        // Add the current cumulative sum to the prefix map
        prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);

        // Recurse for left and right subtrees
        count += pathSumHelper(root.left, currSum, targetSum, prefixSums);
        count += pathSumHelper(root.right, currSum, targetSum, prefixSums);

        // Backtrack: Remove the current cumulative sum from the prefix map
        prefixSums.put(currSum, prefixSums.get(currSum) - 1);

        return count;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

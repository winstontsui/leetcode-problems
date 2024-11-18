/*
 * Leetcode 1526: Minimum Number of Increments to Form Target Array. Java. Medium.
 * O(n) runtime and O(1) space complexity, where n is the length of the target array.
 * The problem is solved by iterating through the array and calculating the number of increments needed to match the target.
 * Each increment is derived from the positive differences between consecutive elements.
 * 11/17/2024 Winston Tsui
 */

 class Solution {
    public int minNumberOperations(int[] target) {
        int minOperations = target[0];

        for (int i = 1; i < target.length; i++)
            if (target[i] > target[i - 1])
                minOperations += target[i] - target[i - 1];

        return minOperations;
    }
}

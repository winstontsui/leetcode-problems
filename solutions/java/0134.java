
// Leetcode 134: Gas Station. Java. Medium.
// O(N) runtime and O(1) space complexity.
// Greedily tracks total gas and cost while identifying a valid starting index by resetting when current fuel goes negative.
// Key Insight: If total gas is at least total cost, a solution exists; the start index is where the running tank drops below zero.
// 4/2/2025 Winston Tsui

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int curTotal = 0;
        int startIdx = 0;
        for (int i = 0; i < gas.length; i++) {
            curTotal += gas[i] - cost[i];
            totalGas += gas[i];
            totalCost += cost[i];
            if (curTotal < 0) {
                curTotal = 0;
                startIdx = i + 1;
            }
        }
        return totalGas >= totalCost ? startIdx : -1;
    }
}

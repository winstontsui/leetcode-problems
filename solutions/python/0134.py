"""
Leetcode 134: Gas Station. Python. Medium.
O(N) runtime and O(1) space complexity.
Greedily tracks total gas and cost while identifying a valid starting index by resetting when current fuel goes negative.
Key Insight: If total gas is at least total cost, a solution exists; the start index is where the running tank drops below zero.
4/2/2025 Winston Tsui
"""


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        total_gas = 0
        total_cost = 0
        start_idx = 0
        cur_total = 0

        for i in range(len(gas)):
            total_gas += gas[i]
            total_cost += cost[i]
            cur_total = cur_total + gas[i] - cost[i]

            if cur_total < 0:
                start_idx = i + 1
                cur_total = 0
        return start_idx if total_cost <= total_gas else -1
    
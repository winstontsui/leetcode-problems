/*
 * Leetcode 1029: Two City Scheduling. Java. Medium.
 * O(n log n) time complexity due to sorting people by the difference between City A and City B costs.
 * Calculate the cost difference between sending someone to City A vs. City B.
 * Sort based on this distance and compute the minimumCost.
 * 11/7/2024 Winston Tsui
 */

import java.util.Arrays;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // Sort by difference in costs: costA - costB
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int n = costs.length / 2;
        int minimumCost = 0;
        // First half goes to City A, second half goes to City B
        for (int i = 0; i < n; i++) {
            minimumCost += costs[i][0]; // Cheaper to send this person to city A
            minimumCost += costs[i + n][1]; // Cheaper to send this person to city B
        }
        return minimumCost;
    }
}

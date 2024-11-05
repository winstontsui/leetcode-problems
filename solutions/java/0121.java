/*
 * Leetcode 121: Best Time to Buy and Sell Stock. Java. Easy.
 * O(n) time complexity, where n is the number of stock prices.
 * Tracks the minimum stock price and calculates potential profits by checking the difference between
 * the current price and the minimum seen so far. Updates maxProfit as higher profits are found.
 * A monotonic stack isn't needed here-- a simple minStock variable is sufficient because there is no need to track indicies.
 * 11/5/2024 Winston Tsui
 */

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minStock = Integer.MAX_VALUE;

        for (int currStock : prices) {
            if (minStock > currStock)
                minStock = currStock; // Stock price went down.
            else
                maxProfit = Math.max(maxProfit, currStock - minStock); // Stock price went up- check profit and update maxProfit as needed.

        }
        return maxProfit;
    }
}

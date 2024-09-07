/*
 * Leetcode 575: Distribute Candies. Java. Easy.
 * O(n) runtime and O(n) space complexity.
 * Use HashSet to store unique candies and return the minimum of the size of the set and n / 2.
 * 9/7/2024 Winston Tsui
*/

import java.util.HashSet;

class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        HashSet<Integer> candies = new HashSet<>();
        int maxNum = 0;

        for (int i = 0; i < n; i++) {
            if (!candies.contains(candyType[i])) {
                candies.add(candyType[i]);
                maxNum++;
            }
        }

        return Math.min(maxNum, n / 2);
    }
}

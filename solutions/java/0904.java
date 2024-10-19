/*
 * Leetcode 904: Fruit Into Baskets. Java. Medium.
 * O(n) runtime and O(1) space complexity.
 * Sliding window problem. Adjust the window's boundaries when traversing to include a maximum of 2 elements using a HashMap.
 * Track the window's length accordingly, returning the maximum possible length.
 * 7/7/2024 Winston Tsui
 */

import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> fruitCount = new HashMap<>();
        int maxFruits = 0;
        int l = 0;
        
        for (int r = 0; r < fruits.length; r++) {
            fruitCount.put(fruits[r], fruitCount.getOrDefault(fruits[r], 0) + 1);
            // Shrink left part of window until it's valid.
            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[l], fruitCount.get(fruits[l]) - 1);
                if (fruitCount.get(fruits[l]) == 0)
                    fruitCount.remove(fruits[l]);
                l++;
            }
            maxFruits = Math.max(maxFruits, r - l + 1);

        }
        return maxFruits;
    }
}

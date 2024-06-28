/*
 * Leetcode 229: Majority Element II. Java. Medium.
 * O(n) runtime and O(1) space complexity.
 * Up to 2 elements can occur over a third of the time in nums. Use a HashMap of size 2 to count occurances
 * of each num, decrementing/removing and adding as needed. If a number is a majority element, it will be present in the hashmap at the end.
 * Verify at the end that leftover elements are the majority element.
 * 6/28/2024 Winston Tsui
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int size = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.size() > 2) {
                List<Integer> keysToRemove = new ArrayList<>();
                for (int n : map.keySet()) {
                    if (map.get(n) == 1)
                        keysToRemove.add(n);
                    else
                        map.put(n, map.get(n) - 1);
                }
                for (Integer key : keysToRemove)
                    map.remove(key);
            }
        }

        // Verify that leftover elements are actually the majority element because they may not be.
        for (int num : map.keySet()) {
            int count = 0;
            for (int n : nums)
                if (num == n)
                    count++;

            if (count > size / 3)
                ans.add(num);
        }

        return ans;
    }
}

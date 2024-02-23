/*
 * Leetcode 1: Two Sum. Java. Easy.
 * Captivating Problem. O(n) runtime and O(n) space complexity.
 * Use a HashMap to store the numbers and indicies of elments in nums. 
 * If the difference between nums[i] and target exists, then a pair exists.
 * 2/23/2024 Winston Tsui
*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i]))
                return new int[] { i, numMap.get(target - nums[i]) };

            // Here, only one valid answer exists, so checking to 
            // see if numMap contains nums[i] isn't necessary.
            if (!numMap.containsKey(nums[i]))
                numMap.put(nums[i], i);
        }

        return null;
    }
}

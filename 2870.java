/*
 * Leetcode 2870: Minimum Number of Operations to Make Array Empty. Java. Medium.
 * HashMap and array problem. O(n) runtime and O(n) spacetime.
 * Trick is to use a HashMap to store the count of each number in nums, 
 * then calculate the min # of operations to make array empty.
 * Some useful HashMap methods: containsKey(Object key), containsValue(Object value), get(Object key), getOrDefault(Object key, 
 * V defaultValue), put(K Key, V Value), remove(Object key) and replace(K key, V Value).
 * 1/6/2024 Winston Tsui
*/

import java.util.HashMap;

class Solution2870 {
    public int minOperations(int[] nums) {
        int total = 0;
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();

        for (int num : nums) {
            // I can also use getOrDefault() method here.
            if (myMap.containsKey(num))
                myMap.put(num, myMap.get(num) + 1);
            else
                myMap.put(num, 1);
        }

        for (Integer num : myMap.keySet()) {
            int item = myMap.get(num);
            if (item == 1)
                return -1;
            // I can do Math.ceil((double) item/3).
            else
                total += (item % 3 == 0) ? (item / 3) : ((item % 3 == 1) ? (2 + (item - 4) / 3) : (1 + (item - 2) / 3));
        }
        return total;
    }
}
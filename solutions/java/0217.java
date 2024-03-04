/*
 * Leetcode 217: Contains Duplicate. Java. Easy.
 * In-order BST traversal. O(n) runtime and O(n) spacetime.
 * Use a HashSet to efficiently store values that we have seen up to the current point.
 * HashSets have O(1) search time.
 * 3/4/2024 Winston Tsui
*/

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> duplicateSet = new HashSet<Integer>();
        for (int num: nums){
            if (duplicateSet.contains(num))
                return true;
            duplicateSet.add(num);
        }
        return false;
    }
}

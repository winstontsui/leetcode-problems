/*
 * Leetcode 442: Find All Duplicates in an Array. Java. Medium.
 * O(n) runtime and O(1) space complexity.
 * Iterate over the array and use each value as an index to mark visited elements by negating the value at that index.
 * If an index is already negative, the corresponding number is a duplicate and is added to the result list.
 * This approach leverages the range [1, n] and modifies the array in place by multiplying by -1.
 * 10/31/2024 Winston Tsui
 */


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // There are only n elements, and each integer appears at most twice, so I can
        // map numbers to indicies and mark visited elements as -1 when visited.
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;

            // Check if the value at this index is already negative (duplicate)
            if (nums[idx] < 0)
                duplicates.add(idx + 1);
            else
                nums[idx] *= -1;
        }
        return duplicates;
    }
}

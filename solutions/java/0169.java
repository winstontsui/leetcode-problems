/*
 * Leetcode 169: Majority Element. Java. Easy.
 * O(n) runtime and O(1) space complexity.
 * Boyer-Moore Majority Voting Algorithm: The # of elements in the minority must be less than the majority.
 * 6/5/2024 Winston Tsui
*/

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;

        // // If there is more than one majority element, return -1.
        // if (count != 0)
        //     return candidate;
        // return -1;
    }
}

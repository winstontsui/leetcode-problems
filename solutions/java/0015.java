/*
 * Leetcode 15: 3Sum. Java. Medium.
 * Tricky Pointer Problem. O(n^2) runtime and O(n) space complexity.
 * The idea is to use three pointers. Sort nums, then use two pointers, one from first+1 and another from the end inwards.
 * Take care of duplicates. If the sum of the three pointers is equal to 0, add to ArrayList.
 * 3/2/2024 Winston Tsui
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> zeroSums = new ArrayList<>();
        Arrays.sort(nums);

        for (int first = 0; first < nums.length - 2; first++) {
            int second = first + 1;
            int third = nums.length - 1;

            // Skip duplicates for the first number.
            if (first > 0 && nums[first] == nums[first - 1])
                continue;

            // Because nums is sorted at this point, just work our way in from both ends of
            // array with second and third pointers.
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];

                if (sum < 0)
                    second++;
                else if (sum > 0)
                    third--;
                else {
                    zeroSums.add(Arrays.asList(nums[first], nums[second], nums[third]));

                    // Skips duplicates that may occur for second and third numbers.
                    while (second < third && nums[second] == nums[second + 1])
                        second++;
                    while (second < third && nums[third] == nums[third - 1])
                        third--;

                    second++;
                    third--;
                }

            }
        }

        return zeroSums;
    }
}
/*
 * Leetcode 18: 4Sum. Java. Medium.
 * Super nasty problem. O(n^3) runtime and O(1) space complexity.
 * The trick is to use two starting pointers at the start of array nums,
 * using two loops, and using the third loop to capture the third and fourth numbers.
 * 1/6/2024 Winston Tsui
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // nums = [-2, -1, 0, 0, 1, 2]
        if (nums.length < 4)
            return result;

        // First two numbers start from the beginning, third and fourth go inwards.
        for (int first = 0; first < nums.length - 2; first++) {
            // Taking care of duplicates. Same goes for second, third and fourth.
            if (first != 0 && nums[first] == nums[first - 1])
                continue;
            for (int second = first + 1; second < nums.length - 1; second++) {
                if (second != first + 1 && nums[second] == nums[second - 1])
                    continue;
                int third = second + 1;
                int fourth = nums.length - 1;
                while (third < fourth) {
                    // Int holding values between -2147483648 and 2147483647 isn't sufficient.
                    long sum = (long) nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (sum < target || third != second + 1 && nums[third] == nums[third - 1])
                        third++;
                    else if (sum > target || fourth != nums.length - 1 && nums[fourth] == nums[fourth + 1])
                        fourth--;
                    else {
                        result.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        third++;
                        fourth--;
                    }
                }
            }
        }
        return result;
    }
}
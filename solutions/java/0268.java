/*
 * Leetcode 268: Missing Number. Java. Easy.
 * O(n) runtime and O(1) space complexity.
 * The missing number is the expected total sum minus the calculated sum.
 * 3/16/2024 Winston Tsui
*/

class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;

        int expectedSum = (len * (len + 1) / 2); // Using sum identity
        // int expectedSum = 0;
        // while (len > -1)
        //     expectedSum += len--;

        for (int num : nums)
            sum += num;

        return expectedSum - sum;
    }
}

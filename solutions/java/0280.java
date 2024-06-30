/*
 * Leetcode 280: Wiggle Sort. Java. Medium.
 * O(n) runtime and O(1) space complexity.
 * Run through nums knowing that odd indicies must have greater values than previous even indicies
 * and that even indicies must have smaller values than previous odd indicies. Swap nums[i] with nums[i-1] if this condition doesn't hold. 
 * 
 * This doesn't mess up previous values--say i is odd. As we go through nums left to right, 
 * nums[i-1] (an even index) is already guaranteed to be <= nums[i-2]. So if nums[i] is <= nums[i-1], (the case where we need to swap),
 * nums[i] MUST be <= nums[i-2]. So swapping nums[i] with nums[i-1] doesn't mess up previous values.
 * 6/28/2024 Winston Tsui
*/

class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // Odd indicies must have greater values than previous even indicies.
            // Even indicies must have smaller values than previous odd indicies.
            // Otherwise, swap nums[i] with nums[i-1].
            if (i % 2 == 1 && nums[i] < nums[i - 1] || i % 2 == 0 && nums[i] > nums[i - 1]) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }
}

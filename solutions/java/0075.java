/*
 * Leetcode 75: Sort Colors. Java. Medium.
 * O(n) runtime and O(1) space complexity.
 * Use two pointers and curr to run through nums. Swap with first pointer if 0 is encountered 
 * and second pointer if 2 is encountered, incrementing/decrementing pointers appropriately.
 * 6/3/2024 Winston Tsui
*/

class Solution {
    /* Dutch National Flag problem solution. */
    public void sortColors(int[] nums) {
        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;

        while (curr <= p2) {
            if (nums[curr] == 0)
                swap(nums, p0++, curr++);
            else if (nums[curr] == 2)
                swap(nums, p2--, curr);
            else
                curr++;
        }
    }

    private void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
}

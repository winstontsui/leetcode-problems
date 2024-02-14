/*
 * Leetcode 31: Next Permutation. Java. Medium.
 * Nightmarish problem. The trick is to find the smallest next number, which means starting from end.
 * Find position of element that desends from the back & swap with its next larger element, this time going forwards.
 * Reverse array from that position+1 to end to get smallest next element. 
 * If no swaps are needed, reverse from beginning.
 * 1/3/2024 Winston Tsui
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        int swapWith; // Position of element in nums that I will potentially swap with.

        // Must go right to left to find next smallest element.
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                swapWith = i + 1;
                // It's better to go right to left but this works.
                while (swapWith < nums.length - 1 && nums[swapWith + 1] > nums[i])
                    swapWith++;
                swap(nums, i, swapWith);
                reverse(nums, i + 1, nums.length - 1);
                return;
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    // Reverses items from array arr from position left to position right.
    // @param right isn't necessary as we always go until the end.
    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    // Swaps element in array arr at position1 with element at position2.
    private void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}

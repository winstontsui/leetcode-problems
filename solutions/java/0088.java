/*
 * Leetcode 88: Merge Sorted Array. Java. Medium.
 * Array algorithm. O(n + m) runtime and O(1) spacetime.
 * Merge two arrays starting from the back, and use three pointers to keep track.
 * Take care of case where there are still elements left over when we finish 
 * processing all the elements in nums1.
 * 2/27/2024 Winston Tsui
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptrNums1 = m - 1;
        int ptrNums2 = n - 1;
        int curr = m + n - 1;

        while (ptrNums1 > -1 && ptrNums2 > -1)
            nums1[curr--] = (nums1[ptrNums1] > nums2[ptrNums2]) ? nums1[ptrNums1--] : nums2[ptrNums2--];

        // Takes care of case where # elements we want to process in nums2 > # elements
        // we want to process in nums1.
        while (ptrNums2 > -1)
            nums1[curr--] = nums2[ptrNums2--];
    }
}

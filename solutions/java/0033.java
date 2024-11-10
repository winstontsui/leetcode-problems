/*
 * Leetcode 33: Search in Rotated Sorted Array. Java. Medium.
 * O(logn) runtime and O(1) space complexity.
 * Nightmarish problem. Perform binary search, keeping in mind if the middle element 
 * is part of the left or right sorted array. After that, perform binary search.
 * 6/17/2024 Winston Tsui
 */

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == target)
                return m;

            // Determines if nums is sorted up to m, inclusive.
            if (nums[m] >= nums[l]) {
                // Determines if we search left or right of m.
                if (nums[m] > target && nums[l] <= target)
                    r = m - 1;
                else
                    l = m + 1;
            } else {
                if (nums[m] < target && nums[r] >= target)
                    l = m + 1;
                else
                    r = m - 1;
            }
        }

        return -1;
    }
}

// class Solution {
//     public int search(int[] nums, int target) {
//         int l = 0;
//         int r = nums.length - 1;
//         while (l <= r) {
//             int mid = (l + r) / 2;

//             if (nums[mid] == target)
//                 return mid;

//             if (nums[l] <= nums[mid]) { // If the left side is sorted
//                 if (nums[l] <= target && target <= nums[mid])
//                     r = mid - 1; // Target is in the left half
//                 else
//                     l = mid + 1; // Target is in the right half
//             } else { // If the right side is sorted
//                 if (nums[mid] <= target && target <= nums[r])
//                     l = mid + 1; // Target is in the right half
//                 else
//                     r = mid - 1; // Target is in the left half
//             }
//         }

//         // Target not found
//         return -1;
//     }
// }

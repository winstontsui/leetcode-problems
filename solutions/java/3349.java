/*
 * Leetcode 3349: Increasing Subsequences in Array. Java. Medium.
 * O(n) runtime and O(1) space complexity, where n is the size of the input list.
 * Maintain lengths of current and previous increasing subarrays. Check whether there exist two consecutive 
 * increasing subarrays of length at least k or one increasing subarray of length 2k.
 * 12/2/2024 Winston Tsui
 */

import java.util.*;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int lengthFirst = 1;
        int lengthSec = 0;

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i))
                lengthFirst++;
            else {
                lengthSec = lengthFirst;
                lengthFirst = 1;
            }
            if (lengthFirst >= k * 2 || (lengthFirst >= k && lengthSec >= k))
                return true;
        }
        return false;
    }
}

// class Solution {
//     public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
//         boolean[] increasing = new boolean[nums.size()];
//         for (int i = k - 1; i < nums.size(); i++) {
//             boolean isIncreasing = true;
//             for (int j = 1; j < k; j++)
//                 if (nums.get(i - j) >= nums.get(i - j + 1))
//                     isIncreasing = false;

//             increasing[i] = isIncreasing;
//         }

//         for (int i = 0; i < nums.size() - k; i++)
//             if (increasing[i] && increasing[i + k])
//                 return true;

//         return false;
//     }
// }

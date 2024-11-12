/*
 * LeetCode 658: Find K Closest Elements. Java. Medium.
 * O(log(n - k) + k) time complexity due to binary search over potential starting positions
 * and O(k) space complexity for storing the result.
 * This approach uses binary search to find the optimal starting position of a window of size k:
 * Use binary search to adjust the starting index `l` by comparing distances of `arr[mid]` and `arr[mid + k]` to x.
 * 11/12/2024 Winston Tsui
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // l and r represent the entire search space.
        int l = 0;
        int r = arr.length - k;

        while (l < r) {
            int mid = (l + r) / 2;
            // Create a window starting from mid.
            // Compare the distances to x to decide which window is closer
            if (arr[mid + k] - x < x - arr[mid]) // If the point just outside window to the right is less than window starting from mid.
                l = mid + 1;
            else
                r = mid;

        }
        List<Integer> ans = new ArrayList<>();
        for (int i = l; i < l + k; i++)
            ans.add(arr[i]);
        return ans;

    }
}

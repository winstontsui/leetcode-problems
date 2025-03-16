/*
 * Leetcode 1200: Minimum Absolute Difference. Java. Easy.
 * O(N log N) runtime and O(N) space complexity.
 * Sort the array, then find minimum absolute difference between adjacent elements.
 * Iterate again to collect all pairs with this minimum difference.
 * 3/15/2025 Winston Tsui
*/

import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++)
            minDiff = Math.min(minDiff, arr[i] - arr[i-1]);
        

        for (int i = 1; i < arr.length; i++){
            if (arr[i] - arr[i-1] == minDiff)
                ans.add(new ArrayList<>(Arrays.asList(arr[i-1], arr[i])));
        }
        
        return ans;
    }
}

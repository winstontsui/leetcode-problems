/*
 * Leetcode 986: Interval List Intersections. Java. Medium.
 * O(m + n) runtime and O(m + n) space complexity.
 * Use a two-pointer technique to iterate through two sorted interval lists and find their intersections.
 * Intervals are added to the result when they overlap, and pointers are moved based on the smaller endpoint.
 * Insights: The key is to compute the intersection range using max(start) and min(end) and advance pointers appropriately to maintain efficiency.
 * 12/24/2024 Winston Tsui
 */

import java.util.*;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> intersectionList = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {
            // If intervals do not overlap
            if (firstList[i][0] > secondList[j][1])
                j++;
            else if (firstList[i][1] < secondList[j][0])
                i++;
            else {
                intersectionList.add(new int[] { Math.max(firstList[i][0], secondList[j][0]),
                        Math.min(firstList[i][1], secondList[j][1]) });

                // Increment the pointer with the smaller ending value.
                if (firstList[i][1] > secondList[j][1])
                    j++;
                else
                    i++;
            }
        }
        return intersectionList.toArray(new int[intersectionList.size()][]);
    }
}

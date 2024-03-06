/*
 * Leetcode 11: Container With Most Water. Java. Medium.
 * Interesting LinkedList problem. O(n) runtime and O(1) space complexity.
 * Trick is to use two pointers and update them accordingly.
 * 1/26/2024 Winston Tsui
*/

class Solution {
    public int maxArea(int[] height) {
        // Two pointer approach.
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currWidth = right - left;
            int currHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currWidth * currHeight);

            // Update pointers accordingly. If both values are the same height, 
            // it doesn't matter what I do.
            if (height[left] > height[right])
                right--;
            else
                left++;
        }
        return maxArea;

    }
}

// class Solution11 {
//     // O(n^2) time, O(1) space. Not Efficient.
//     public int maxArea(int[] height) {
//         // Area = length * width.
//         // width = difference between two pointers.
//         // height = min(height[left], height[right]).
//         // Update Area accordingly.
//         // O(n^2) time, O(1) space. Not Efficient.
//         int maxArea = 0;

//         for (int left = 0; left < height.length - 1; left++) {
//             for (int right = left + 1; right < height.length; right++) {
//                 int rectWidth = right - left;
//                 int rectHeight = Math.min(height[left], height[right]);
//                 maxArea = Math.max(rectHeight * rectWidth, maxArea);
//             }
//         }

//         return maxArea;
//     }
// }

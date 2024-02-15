/*
 * Leetcode 223: Rectangle Area. Java. Medium.
 * Nice problem. O(1) runtime and O(1) spacetime.
 * Compute the overlapping area's width and height and subtract this 
 * overlapping rectangle from the area of the two given rectangles.
 * 2/15/2024 Winston Tsui
*/

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // Area = rect1 + rect2 - overlapping(rect1, rect2)
        int areaRect1 = (ax2 - ax1) * (ay2 - ay1);
        int areaRect2 = (bx2 - bx1) * (by2 - by1);

        int overlapWidth = Math.max(Math.min(ax2, bx2) - Math.max(bx1, ax1), 0);
        int overlapHeight = Math.max(Math.min(ay2, by2) - Math.max(by1, ay1), 0);

        return areaRect1 + areaRect2 - (overlapWidth * overlapHeight);
    }   
}

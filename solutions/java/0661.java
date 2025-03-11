/*
 * Leetcode 661: Image Smoother. Java. Easy.
 * O(M × N) runtime and O(M × N) space complexity.
 * Iterate over each pixel and calculate average of all valid adjacent pixels in a 3x3 window.
 * Take care of edge cases.
 * 3/11/2025 Winston Tsui
*/

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] ans = new int[img.length][img[0].length];

        for (int r = 0; r < img.length; r++) {
            for (int c = 0; c < img[0].length; c++) {
                int count = 0;
                int total = 0;
                for (int r2 = r - 1; r2 < r + 2; r2++) {
                    for (int c2 = c - 1; c2 < c + 2; c2++) {
                        // If this is in bounds, count this and average it.
                        if (r2 >= 0 && c2 >= 0 && r2 < img.length && c2 < img[0].length) {
                            count++;
                            total += img[r2][c2];
                        }
                    }
                }
                ans[r][c] = total / count;
            }
        }
        return ans;
    }
}

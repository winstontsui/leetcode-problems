/*
 * Leetcode 74: Search a 2D Matrix. Java. Medium.
 * Good refresher problem on binary search. O(log(n*m)) runtime and O(1) spacetime.
 * Tough binary search matrix problem. The trick is to do binary search twice—once on the first column
 * and again on the row if target is not found. Must check conditions to know what row to stop.
 * 1/3/2024 Winston Tsui
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numRows = matrix.length;
        int left = 0;
        int right = numRows - 1;
        int middle = (left + right) / 2;

        // Checking which row may contain target. If the first item in that row is
        // target, return true.
        while (left <= right) {
            middle = (left + right) / 2;
            if (matrix[middle][0] == target)
                return true;
            else if (middle == numRows - 1
                    || matrix[middle][0] < target && middle + 1 < numRows && matrix[middle + 1][0] > target)
                break;
            else if (matrix[middle][0] < target)
                left = middle + 1;
            else
                right = middle - 1;
        }

        // Now search inside that row to see if it is there.
        left = 0;
        right = matrix[middle].length - 1;
        while (left <= right) {
            int element = (left + right) / 2;
            if (matrix[middle][element] == target)
                return true;
            else if (matrix[middle][element] < target)
                left = element + 1;
            else
                right = element - 1;
        }
        return false;
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Determine possible row with binary search
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            int n = matrix[0].length;
            int conversion = matrix[m / n][m % n]; // Converting 1D mid index to 2D index

            if (conversion == target)
                return true; // Target found
            else if (target < conversion)
                r = m - 1; // Search left subspace
            else
                l = m + 1; // Search right subspace
        }
        return false;

    }
}

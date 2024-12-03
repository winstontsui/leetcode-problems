/*
 * Leetcode 6: Zigzag Conversion. Java. Medium.
 * O(n) runtime and O(n) space complexity, where n is the length of the input string.
 * The problem is solved by simulating the zigzag traversal row by row.
 * For each row, characters are added from the vertical and diagonal positions
 * based on the calculated cycle length. The result is built efficiently using a
 * StringBuilder to minimize overhead.
 * 12/3/2024 Winston Tsui
 */

class Solution {
    public String convert(String s, int numRows) {
        // If the string is too short or the number of rows is 1, no zigzagging is needed.
        if (s.length() == 1 || numRows == 1 || s.length() <= numRows)
            return s;

        StringBuilder str = new StringBuilder();
        // Cycle length numRows + another one for the diagonals minus 2 for the top and bottom row.
        int cycleLen = numRows + numRows - 2;

        // Iterate through each row of the zigzag pattern.
        for (int r = 0; r < numRows; r++){
            // Traverse each character in the current row across all cycles.
            for (int j = r; j < s.length(); j += cycleLen){
                // Append every "column"
                str.append(s.charAt(j));

                // Append diagonal characters
                if (r > 0 && r < numRows-1 && j+cycleLen - 2*r < s.length()){
                    str.append(s.charAt(j+cycleLen - 2*r));
                }
            }
        }
        return str.toString();
    }
}

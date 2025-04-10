/*
 * Leetcode 151: Reverse Words in a String. Java. Medium.
 * O(N) runtime and O(N) space complexity.
 * Trims the string and splits it using a regex that handles one or more spaces, then rebuilds the sentence in reverse order.
 * Key Insight: Splitting on "\\s+" skips multiple spaces and gives clean word tokens.
 *
 * Input: s = "  a good   example  "
 * 
 * Step 1: Trim and split by one or more spaces
 *   split[] = ["a", "good", "example"]
 * 
 * Step 2: Append words from split[] in reverse using StringBuilder
 *   reversed = "example good a"
 *
 * 4/10/2025 Winston Tsui
*/

class Solution {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();

        for (int i = split.length - 1; i >= 0; i--) {
            reversed.append(split[i]);
            if (i > 0)
                reversed.append(" ");
        }
        return reversed.toString();
    }
}

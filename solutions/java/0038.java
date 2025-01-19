/*
 * Leetcode 38: Count and Say. Java. Medium.
 * O(n * m) runtime and O(m) space complexity, where n is the number of terms 
 * and m is the average length of terms in the sequence. 
 * Iteratively generate each term using Run-Length Encoding (RLE), 
 * where each term describes the previous one. 
 * Insights: The sequence's terms grow exponentially in length, so the algorithm 
 * efficiently constructs each term using StringBuilder for concatenation.
 * 1/18/2025
 */

 class Solution {
    public String countAndSay(int n) {
        /*
         * countAndSay(1) = "1"
         * countAndSay(2) = RLE of "1" = "11"
         * countAndSay(3) = RLE of "11" = "21"
         * countAndSay(4) = RLE of "21" = "1211"
         * 
         * "13322251"
         * 23321511
         * 
         */
        String str = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder nextTerm = new StringBuilder();

            int count = 1;
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) != str.charAt(j - 1)) {
                    nextTerm.append(count).append(str.charAt(j - 1));
                    count = 1;
                } else
                    count++;
            }
            nextTerm.append(count).append(str.charAt(str.length() - 1));

            str = nextTerm.toString();
        }
        return str;

    }
}

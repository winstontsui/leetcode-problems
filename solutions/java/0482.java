/*
 * Leetcode 482: License Key Formatting. Java. Easy.
 * O(N) runtime and O(N) space complexity.
 * Clean the input by removing dashes and capitalizing all letters, then groups characters in reverse from the end.
 * Key Insight: Reversing simplifies grouping by `k` from the end and avoids calculating the first group size upfront.
 * 4/6/2025 Winston Tsui
*/

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray())
            if (c != '-')
                cleaned.append(Character.toUpperCase(c));

        /*
        s = "5F3Z-2e-9-w", k = 4
        cleaned = "5F3Z2E9W"
        ans = W9E2-Z3F5
        */
        StringBuilder ans = new StringBuilder();
        int currK = 0;
        for (int i = cleaned.length()-1; i >= 0; i--){
            ans.append(cleaned.charAt(i));
            if (++currK == k && i > 0){
                ans.append('-');
                currK = 0;
            }
        }

        return ans.reverse().toString();
    }
}

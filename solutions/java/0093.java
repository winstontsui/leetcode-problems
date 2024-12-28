/*
 * Leetcode 93: Restore IP Addresses. Java. Medium.
 * O(3^4) runtime and O(1) space complexity (excluding result storage).
 * This solution uses backtracking to generate all valid IP addresses from a given string.
 * It explores segments of length 1 to 3, ensuring each segment is valid (value < 256, no leading zeros) and places dots to form the IP address.
 * Insights: The challenge lies in carefully managing the placement of dots and validating segments during backtracking.
 * 12/28/2024 Winston Tsui
 */

import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();

        // If there's no possible valid IP address.
        if (s.length() > 12)
            return ans;

        backtrack(ans, 0, 0, s, new StringBuilder());
        return ans;
    }

    private void backtrack(List<String> ans, int start, int dots, String s, StringBuilder curr) {
        // Base case: If we placed 4 dots and used up the entire string
        if (dots == 4 && start == s.length()) {
            ans.add(curr.substring(0, curr.length() - 1));
            return;
        }

        // Explore segments of length 1, 2, or 3
        for (int end = start; end < Math.min(start + 3, s.length()); end++) {
            String candidate = s.substring(start, end + 1);
            if (Integer.parseInt(candidate) < 256 && (candidate.length() == 1 || candidate.charAt(0) != '0')) {
                int prevSize = curr.length();
                curr.append(candidate);
                curr.append('.');

                backtrack(ans, end + 1, dots + 1, s, curr);

                curr.delete(prevSize, curr.length()); // Backtrack: Remove the added segment and dot
            }
        }
    }
}

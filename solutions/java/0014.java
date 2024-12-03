/*
 * Leetcode 14: Longest Common Prefix. Java. Easy.
 * O(n * log(m)) runtime and O(1) space complexity, where n is the number of strings
 * and m is the length of the shortest string in the array. 
 * This problem is solved using binary search on the prefix length. 
 * For each candidate prefix, the algorithm checks if it is a valid prefix for all strings.
 * This efficient solution minimizes the number of string comparisons.
 * 12/3/2024 Winston Tsui
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Find shortest string length in strs for r in binary search.
        int l = 0;
        int r = strs[0].length();

        for (int i = 1; i < strs.length; i++)
            r = Math.min(strs[i].length(), r);

        // Binary search to determine lonest common prefix string. substr(0, mid)
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isValidPrefix(strs[0].substring(0, mid), strs))
                l = mid + 1; // Try a longer prefix
            else
                r = mid - 1; // Try a shorter prefix
        }
        return strs[0].substring(0, r);
    }

    // Determines if s is a valid prefix in all strings in strs.
    private boolean isValidPrefix(String s, String[] strs) {
        for (String str : strs)
            if (str.indexOf(s) != 0)
                return false;
        return true;
    }
}

// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         String check = strs[0];
//         for (int i = 1; i < strs.length; i++) {
//             if (check.length() == 0)
//                 return "";
//             while (strs[i].indexOf(check) != 0) {
//                 check = check.substring(0, check.length() - 1);
//             }
//         }
//         return check;
//     }
// }

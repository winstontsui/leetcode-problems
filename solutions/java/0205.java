/*
 * Leetcode 205: Isomorphic Strings. Java. Easy.
 * O(N) runtime and O(1) space complexity.
 * Use two 256-length arrays to track one-to-one character mappings between strings `s` and `t`.
 * Tricky Part: Simultaneously checking both forward and reverse mappings to prevent conflicts.
 * 4/6/2025 Winston Tsui
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] mapST = new char[256];
        char[] mapTS = new char[256];

        for (int i = 0; i < s.length(); i++) {
            char currS = s.charAt(i);
            char currT = t.charAt(i);

            if (mapST[currS] != 0 && mapST[currS] != currT || mapTS[currT] != 0 && mapTS[currT] != currS)
                return false;

            mapST[currS] = currT;
            mapTS[currT] = currS;

        }
        return true;
    }
}

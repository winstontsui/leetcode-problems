/*
 * Leetcode 344: Reverse String. Java. Easy.
 * O(n) runtime and O(1) space complexity.
 * Store each character one by one in a temporary variable as I run through s.
 * 5/14/2024 Winston Tsui
*/

class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}

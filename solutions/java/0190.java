/*
 * Leetcode 190: Reverse Bits. Java. Easy.
 * Check boundary bits. O(1) runtime and O(1) space complexity.
 * Keep a reversed integer variable and use bit manipulation to process all 32 bits.
 * 3/14/2024 Winston Tsui
*/

class Solution {
    // Treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            int curr = (n >> i) & 1;
            reversed = reversed | curr << (31 - i);
        }

        return reversed;
    }
}

/*
 * Leetcode 191: Number of 1 Bits. Java. Easy.
 * O(1) runtime and O(1) space complexity. O(32) becomes O(1) runtime complexity.
 * Use bitwise and left shift operators to count the number of ones in this 32 bit integer.
 * 3/10/2024 Winston Tsui
*/

class Solution {
    public int hammingWeight(int n) {
        int numOnes = 0;
        for (int i = 32; i > 0; i--) {
            if ((n & 1) == 1)
                numOnes++;
            n >>= 1;
        }
        return numOnes;
    }
}

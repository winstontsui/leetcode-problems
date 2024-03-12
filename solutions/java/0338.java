/*
 * Leetcode 338: Counting Bits. Java. Easy.
 * O(n) runtime and O(n) space complexity.
 * I'm shifting all 1 bits from i/2 to the left. If i is odd, 
 * there is an additional one bit at the rightmost index so add one to count.
 * 3/11/2024 Winston Tsui
*/

class Solution {
    public int[] countBits(int n) {
        int[] numOneBits = new int[n + 1];
        for (int i = 1; i < n + 1; i++)
            numOneBits[i] = numOneBits[i / 2] + i % 2;

        return numOneBits;
    }
}

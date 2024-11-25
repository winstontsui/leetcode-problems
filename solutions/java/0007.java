/*
 * Leetcode 7: Reverse Integer. Java. Medium.
 * O(log10(x)) runtime and O(1) space complexity, where x is the input integer.
 * The problem is solved by iteratively reversing the digits of the input number using modulo and division operations.
 * Proper overflow checks are implemented to ensure that the reversed number does not exceed 32-bit signed integer bounds.
 * The code handles both positive and negative numbers seamlessly.
 * 11/25/2024 Winston Tsui
 */

class Solution {
    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10; // Extract the last digit
            x /= 10; // Remove the last digit from x

            // Check for positive/negative overflow before updating reversed
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && x > 7))
                return 0;

            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && x < -8)) {
                return 0;
            }

            // Update the reversed number
            reversed = reversed * 10 + digit;
        }
        return reversed;
    }
}

/*
 * Leetcode 9: Palindrome Number. Java. Easy.
 * O(log n) runtime and O(1) space complexity, where n is the input number.
 * Reverse second half of the digits of x and comparing it with the first half. 
 * Numbers ending in 0 except 0 are not palindromes. Negative numbers are also not palindromes.
 * 11/18/2024 Winston Tsui
 */

 class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int reverse = 0;

        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse ? true : x == reverse / 10;
    }
}

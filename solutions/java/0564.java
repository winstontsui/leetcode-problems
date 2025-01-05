/*
 * Leetcode 564: Find the Closest Palindrome. Java. Hard.
 * O(L) runtime and O(L) space complexity, where L is the length of the input number n.
 * This solution generates candidate palindromes by mirroring and modifying the prefix of n.
 * Edge cases like single-digit numbers, powers of ten, and all nines are handled explicitly.
 * Tie-breaking ensures the smaller palindrome is selected if two candidates have the same distance.
 * 1/4/2025 Winston Tsui
 */

class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.valueOf(n);
        int size = n.length();

        // Handle edge cases
        if (num <= 10)
            return String.valueOf(num - 1);
        if (num == Math.pow(10, size - 1))
            return String.valueOf(num - 1);

        long higherPower = (long) Math.pow(10, size) + 1;
        long lowerPower = (long) Math.pow(10, size - 1) - 1;

        long prefix = Long.valueOf(n.substring(0, (size + 1) / 2));
        boolean isEvenLength = size % 2 == 0;
        long[] candidates = new long[] { higherPower, lowerPower, generateNumber(prefix, isEvenLength),
                generateNumber(prefix + 1, isEvenLength), generateNumber(prefix - 1, isEvenLength) };

        long nearestPalindrome = Long.MAX_VALUE;
        long nearestDistance = Long.MAX_VALUE;
        for (long candidate : candidates) {
            long distance = Math.abs(candidate - num);
            if (candidate != num
                    && (distance < nearestDistance || (distance == nearestDistance && candidate < nearestPalindrome))) {
                nearestPalindrome = candidate;
                nearestDistance = distance;
            }
        }
        return String.valueOf(nearestPalindrome);
    }

    private long generateNumber(long prefix, boolean isEvenLength) {
        String prefixStr = String.valueOf(prefix);
        String suffix = new StringBuilder(prefixStr).reverse().toString();

        if (isEvenLength)
            return Long.valueOf(prefixStr + suffix);
        return Long.valueOf(prefixStr + suffix.substring(1));
    }
}

/*
 * Leetcode 12: Integer to Roman. Java. Medium.
 * O(1) runtime and O(1) space complexity due to the fixed number of Roman numeral values.
 * Use a greedy algorithm, iterating from the largest Roman numeral value to the smallest.
 * For each numeral, subtract its value from the input number and append its symbol to the result string.
 * This approach ensures the Roman numeral is constructed correctly in decreasing order of value.
 * 12/5/2024 Winston Tsui
 */

class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        int[] numbers = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] digits = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

        // Traverse from largest to smallest value
        for (int i = numbers.length - 1; i > -1; i--) {
            while (num >= numbers[i]) {
                ans.append(digits[i]);
                num -= numbers[i];
            }
        }
        return ans.toString();
    }
}

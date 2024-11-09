/*
 * LeetCode 1281: Subtract the Product and Sum of Digits of an Integer. Java. Easy.
 * O(d) time complexity, where d is the number of digits in n.
 * Calculates product and sum of digits by extracting each digit with modulo and division.
 * Subtracts sum from product and returns the result.
 * 11/9/2024 Winston Tsui
 */
class Solution {
    public int subtractProductAndSum(int n) {
        int sumOfDigits = 0;
        int productOfDigits = 1;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            sumOfDigits = sumOfDigits + digit;
            productOfDigits = productOfDigits * digit;
        }
        return productOfDigits - sumOfDigits;

    }
}

// class Solution {
//     public int subtractProductAndSum(int n) {
//         int sumOfDigits = 0;
//         int productOfDigits = 1;
//         for (Character c : (n + "").toCharArray()) {
//             sumOfDigits = sumOfDigits + (c - '0');
//             productOfDigits = productOfDigits * (c - '0');
//         }
//         return productOfDigits - sumOfDigits;

//     }
// }

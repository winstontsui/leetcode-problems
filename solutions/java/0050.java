/*
 * Leetcode 50: Pow(x, n). Java. Medium.
 * O(log(n)) runtime and O(log(n)) space complexity.
 * The basic idea is that x^n equals (x*x)^(n/2) if n is even and x^n equals (x*x)^(n/2) * x if n is odd.
 * So for example, 2^10 = 4^5 = 16^2 * 4 = 256^1 * 4.
 * Deal with negative n values and recursive base cases appropriately.
 * 6/2/2024 Winston Tsui
*/

class Solution {
    public double myPow(double x, int n) {
        // Handle the case where n is Integer.MIN_VALUE
        int N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return pow(x, N);
    }

    private double pow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        // x^n equals (x*x)^(n/2) if n is even and x^n equals (x*x)^(n/2) * x if n is odd.
        if (n % 2 == 0)
            return pow(x * x, n / 2);
        return x * pow(x * x, n / 2);
    }
}

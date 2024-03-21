
/*
 * Leetcode 1047: Remove All Adjacent Duplicates In String. Java. Easy.
 * O(n) runtime and O(n) space complexity. 
 * Run through s and use a stack to keep track of duplicates, especially when they need to be removed.
 * 3/21/2024 Winston Tsui
*/
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeDuplicates(String s) {
        // Remove from FRONT of deque (default behavior), add to FRONT of deque.
        Deque<Character> stack = new ArrayDeque<Character>();
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c)
                stack.remove();
            else
                stack.addFirst(c);
        }
        while (!stack.isEmpty())
            str.append(stack.pop());

        // Reverse contents in stack and put them in str.
        return str.reverse().toString();

        // // O(n^2) time complexity because of substring, O(1) space complexity.
        // for (int i = 0; i < s.length(); i++) {
        //     if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
        //         s = s.substring(0, i - 1) + s.substring(i + 1);
        //         i -= 2;
        //     }
        // }
        // return s;
    }
}

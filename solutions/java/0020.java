/*
 * Leetcode 20: Valid Parentheses. Java. Easy.
 * O(n) runtime and O(n) spacetime solution.
 * Use a map to store pairs of parentheses and a stack throughout processing of String s
 * to verify that parentheses match--if they do, pop the stack. If elements remain at the end, the string is not valid.
 * 3/5/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Set;


// A more concise solution that takes advantage of hardcoded parentheses values through a HashMap.
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        HashMap<Character, Character> mapping = new HashMap<Character, Character>();
        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');

        for (char c : s.toCharArray()) {
            if (!mapping.containsKey(c))
                stack.add(c);
            else {
                if (stack.isEmpty())
                    return false;
                if (stack.removeLast() != mapping.get(c))
                    return false;
            }
        }

        return stack.isEmpty();
    }
}

// class Solution {
//     public boolean isValid(String s) {
//         Deque<Character> stack = new ArrayDeque<Character>();
//         Set<Character> opening = Set.of('(', '[', '{');

//         for (int i = 0; i < s.length(); i++) {
//             Character currChar = s.charAt(i);

//             if (opening.contains(currChar))
//                 stack.add(currChar);
//             else {
//                 if (stack.size() == 0)
//                     return false;
//                 Character starting = stack.removeLast(); // We can also do pop()

//                 switch (currChar) {
//                     case ')':
//                         if (starting != '(')
//                             return false;
//                         break;
//                     case ']':
//                         if (starting != '[')
//                             return false;
//                         break;
//                     case '}':
//                         if (starting != '{')
//                             return false;
//                         break;
//                 }
//             }
//         }

//         if (stack.size() != 0)
//             return false;
//         return true;
//     }
// }

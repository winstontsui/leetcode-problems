/*
 * Leetcode 150: Evaluate Reverse Polish Notation. Java. Medium.
 * O(n) runtime and O(n) spacetime solution.
 * Use a stack data structure to keep track of operands, and whenever we see an operator, 
 * pop the last two values in the stack and compute values. Return last remaining value in stack.
 * 3/5/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

class Solution {
    public int evalRPN(String[] tokens) {

        // Here, I add to front, so add() operation remains the same,
        // but remove from the back, so use removeLast() because of stack property.
        Deque<Integer> operandStack = new ArrayDeque<>();
        Set<String> operators = Set.of("+", "-", "*", "/");

        for (String s : tokens) {
            if (!operators.contains(s)) {
                Integer currOperand = Integer.valueOf(s);
                operandStack.add(currOperand);
            } else {
                Integer second = operandStack.removeLast();
                Integer first = operandStack.removeLast();
                Integer result = 0;

                switch (s) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = first / second;
                        break;
                }
                operandStack.add(result);
            }
        }
        return operandStack.peek();
    }

    // Integer intValue1 = Integer.valueOf("123"); // Returns an Integer object
    // int intValue2 = Integer.parseInt("123"); // Returns a primitive int
}

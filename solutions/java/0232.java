/*
 * Leetcode 232: Implement Queue using Stacks. Java. Easy.
 * Amortized O(1) runtime and O(n) space complexity.
 * The second stack holds everything in stack 1 in reverse whenever we pop or peek. The idea is to push onto stack 1 
 * and pop/peek from stack 2, where contents are reversed, so we can remove elements in the "front" of the stack.
 * 6/17/2024 Winston Tsui
 */

import java.util.Stack;

class MyQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>(); // The "reverse" of stack 1, used to peek and pop in O(1) time.

    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        // Remove everything from stack 1 and put to stack 2, that is, 
        // unless there is already something in stack 2.
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        // Same idea as pop but peek instead of pop.
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */

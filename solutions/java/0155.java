/*
 * Leetcode 155: Min Stack. Java. Medium.
 * O(n) runtime and O(n) space complexity.
 * The trick is to store the min element in the stack so I can getMin() at any point.
 * 6/6/2024 Winston Tsui
*/

import java.util.ArrayList;

class MinStack {
    private ArrayList<Integer[]> stack;

    public MinStack() {
        stack = new ArrayList<Integer[]>();
    }

    public void push(int val) {
        if (stack.isEmpty())
            stack.add(new Integer[] { val, val });
        else
            stack.add(new Integer[] { val, Math.min(val, getMin()) });

    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1)[0];
    }

    public int getMin() {
        return stack.get(stack.size() - 1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

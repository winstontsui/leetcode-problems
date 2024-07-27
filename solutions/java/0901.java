/*
 * Leetcode 901: Online Stock Span. Java. Medium.
 * O(1) runtime per next() call and O(n) space complexity.
 * Use a monotonic decreasing stack to track prices and their corresponding day's span. 
 * If today's price is greater than the price at top of the stack, pop until it isn't and add today's price and span.
 * 7/26/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    Deque<Integer[]> deque = new ArrayDeque<>(); // [price, span]

    public StockSpanner() {

    }

    public int next(int price) {
        int newSpan = 1;
        while (!deque.isEmpty() && deque.peek()[0] <= price)
            newSpan += deque.pop()[1];
        deque.addFirst(new Integer[] { price, newSpan });
        return newSpan;
    }
}

/*
 * Leetcode 933: Number of Recent Calls. Java. Easy.
 * O(1) runtime and O(1) space complexity. Technically both are O(3000) which is O(1).
 * It's guaranteed that successive pings will have larger t values. Create a deque holding these pings,
 * adding and removing as necessary.
 * 6/15/2024 Winston Tsui
 */

import java.util.ArrayDeque;
import java.util.Deque;

class RecentCounter {

    Deque<Integer> ans = new ArrayDeque<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        ans.add(t);
        while (ans.peek() < t - 3000) {
            ans.remove();
        }
        return ans.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter(); int param_1 = obj.ping(t);
 */

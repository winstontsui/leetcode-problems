/*
 * Leetcode 853: Car Fleet. Java. Medium.
 * O(nlogn) runtime and O(n) space complexity.
 * Use a stack keeping track of car positions and speed. Sort in increasing order by position.
 * Pop elements off the stack, calculating the time to completion. If an earlier car takes less time
 * than a later car to finish, they form a fleet, so do not add to ans.
 * 6/10/2024 Winston Tsui
 */

import java.util.ArrayList;

class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        // stackitem[0] holds position, stackitem[1] holds speed.
        ArrayList<Integer[]> stack = new ArrayList<>();
        int ans = 0;
        double prevTime = Integer.MIN_VALUE;

        // Add stackitems, sorting based on stackitem[1]
        for (int i = 0; i < position.length; i++) {
            stack.add(new Integer[]{position[i], speed[i]});
        }

        stack.sort((a, b) -> a[0] - b[0]);

        while (!stack.isEmpty()) {
            Integer[] currItem = stack.remove(stack.size() - 1);
            double time = (double) (target - currItem[0]) / currItem[1];

            if (prevTime < time) {
                ans++;
                prevTime = time;
            }

        }

        return ans;

    }
}

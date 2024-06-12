/*
 * Leetcode 1436: Destination City. Java. Easy.
 * O(n) runtime and O(n) space complexity.
 * Create a Hashset to store origin cities and iterate through paths to find
 * the destination city NOT in the hashset, and return it.
 * 6/12/2024 Winston Tsui
 */

import java.util.HashSet;
import java.util.List;

class Solution {

    public String destCity(List<List<String>> paths) {
        HashSet<String> starting = new HashSet<>();

        for (List<String> path : paths) {
            starting.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!starting.contains(path.get(1))) {
                return path.get(1);
            }
        }

        return "";
    }
}

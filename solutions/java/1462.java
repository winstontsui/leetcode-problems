/*
 * Leetcode 1462: Course Schedule IV. Java. Medium.
 * O(V^3) runtime and O(V^3) space complexity.
 * Nasty nasty problem, revisit in the future.
 * 6/5/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        HashMap<Integer, ArrayList<Integer>> directPrereqs = new HashMap<Integer, ArrayList<Integer>>();

        // allPrereqs maps each course to its direct and indirect prerequisites.
        // Use HashSet for O(1) access later on.
        HashMap<Integer, HashSet<Integer>> allPrereqs = new HashMap<Integer, HashSet<Integer>>();
        List<Boolean> ans = new ArrayList<Boolean>();

        // Initalize both graphs.
        for (int i = 0; i < numCourses; i++) {
            directPrereqs.put(i, new ArrayList<>());
            allPrereqs.put(i, new HashSet<>());
        }

        // Build prereq graph of {course#, {all prereqs for course#}}
        for (int[] prereq : prerequisites)
            directPrereqs.get(prereq[1]).add(prereq[0]);

        // bfs finds ALL prerequsites for each course and puts it in allPrereqs.
        for (int i = 0; i < numCourses; i++) {
            Deque<Integer> deque = new ArrayDeque<Integer>();
            deque.add(i);
            while (!deque.isEmpty()) {
                int course = deque.remove();
                for (int next : directPrereqs.get(course)) {
                    if (!allPrereqs.get(i).contains(next)) {
                        allPrereqs.get(i).add(next);
                        deque.add(next);
                    }
                    allPrereqs.get(i).addAll(allPrereqs.get(next));
                }

            }
        }

        for (int[] query : queries)
            ans.add(allPrereqs.get(query[1]).contains(query[0]));

        return ans;
    }
}

/*
 * Leetcode 150: Course Schedule. Java. Medium.
 * Horrible graph question. O(n+m) runtime and O(n+m) spacetime solution.
 * Use a HashMap to keep track of all prerequisites for all courses. For each course,
 * use depth-first search to ensure no cycles exist, or else return false.
 * n is numCourses and m is prerequisites.length.
 * 3/5/2024 Winston Tsui
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Maps each course to its prereq for ALL courses.
        HashMap<Integer, List<Integer>> prereq = new HashMap<>();
        HashSet<Integer> visited = new HashSet<Integer>();

        // Fill up the prereq graph adjacency list with values.
        // for (int[] curr : prerequisites) System.out.println(Arrays.toString(curr));
        for (int[] currPrereq : prerequisites) {
            if (prereq.containsKey(currPrereq[0]))
                prereq.get(currPrereq[0]).add(currPrereq[1]);
            else
                prereq.put(currPrereq[0], new ArrayList<>(Arrays.asList(currPrereq[1])));
        }

        // Ensures that courses without prerequisites have empty mappings.
        for (int i = 0; i < numCourses; i++) {
            if (!prereq.containsKey(i))
                prereq.put(i, new ArrayList() {});
        }

        // Courses are numbered from 0 to numCourses-1, so ensure there are no loops for
        // ALL courses.
        for (int currCourse = 0; currCourse < numCourses; currCourse++) {
            if (dfs(currCourse, prereq, visited) == false)
                return false;
        }

        return true;
    }

    // Returns true if a cycle is detected in any int[] in prerequisites, otherwise returns false.
    private boolean dfs(int currCourse, HashMap<Integer, List<Integer>> prereq, HashSet<Integer> visited) {
        if (prereq.get(currCourse).isEmpty())
            return true;
        if (visited.contains(currCourse))
            return false;

        // Use a HashSet to keep track of previously accessed nodes to detect cycles.
        visited.add(currCourse);
        for (Integer num : prereq.get(currCourse)) {
            if (dfs(num, prereq, visited) == false)
                return false;
        }
        visited.remove(currCourse);

        // Saves us work from having to recompute previously accessed nodes--
        // At this point, we already know there is no cycle.
        prereq.put(currCourse, new ArrayList() {});

        return true;
    }
}

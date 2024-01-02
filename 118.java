/*
 * Leetcode 118: Pascal's Triangle. Java. Easy.
 * Iterative solution where the contents of each row depends on the previous row. O(numRows^2) runtime and spacetime.
 * Note to self that I create a new ArrayList in one line via:
 * List<Integer> myList = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
 * 1/1/2024 Winston Tsui
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList();

        ans.add(new ArrayList<Integer>(Arrays.asList(1)));
        if (numRows != 1)
            ans.add(new ArrayList<Integer>(Arrays.asList(1, 1)));

        int row = 1;
        while (row < numRows-1) {
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for (int i = 1; i<ans.size(); i++)
                curr.add(ans.get(row).get(i) + ans.get(row).get(i-1));
            curr.add(1);
            ans.add(curr);
            row++;
        }
        return ans;
    }
}
package utility;

import java.util.List;

/**
 * Interface representing array utilities.
 * @author Winston Tsui
 */
public interface ArrayWinston {

    /**
     * Finds two numbers in the given array that sum up to the target.
     * 
     * @param nums the array of integers
     * @param target the target sum
     * @return an array containing the indices of the two numbers whose sum matches the target,
     *         or an empty array if no such pair is found
     * @see <a href="https://leetcode.com/problems/two-sum/">LeetCode 1: Two Sum</a>
     */
    int[] twoSum(int[] nums, int target);

    /**
     * Finds four numbers in the given array that sum up to the target.
     * 
     * @param nums the array of integers
     * @param target the target sum
     * @return a list of lists, each containing four numbers whose sum matches the target
     * @see <a href="https://leetcode.com/problems/4sum/">LeetCode 18: 4Sum</a>
     */
    public List<List<Integer>> fourSum(int[] nums, int target);

    
}

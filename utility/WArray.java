package utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Utility class for array operations.
 * 
 * @author Winston Tsui
 */
public class WArray {

    /**
     * Reverses the elements in the array within the specified range.
     *
     * @param arr   the array of integers
     * @param left  the index of the leftmost element in the range
     * @param right the index of the rightmost element in the range
     */
    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    /**
     * Swaps the elements in the array at the specified positions.
     *
     * @param arr  the array of integers
     * @param pos1 the index of the first element to swap
     * @param pos2 the index of the second element to swap
     */
    private void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    /**
     * Finds two numbers in the given array that sum up to the target.
     *
     * @see <a href="https://leetcode.com/problems/two-sum/">LeetCode 1: Two Sum</a>
     * @param nums   the array of integers
     * @param target the target sum
     * @return an array containing the indices of the two numbers whose sum matches
     *         the target or an empty array if no such pair is found
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i]))
                return new int[] { i, numMap.get(target - nums[i]) };

            // Here, only one valid answer exists, so checking to
            // see if numMap contains nums[i] isn't necessary.
            if (!numMap.containsKey(nums[i]))
                numMap.put(nums[i], i);
        }

        return new int[0];
    }

    /**
     * Finds all unique quadruplets in the given array that sum up to the target.
     * Each quadruplet consists of four distinct integers chosen from the array.
     *
     * @see <a href="https://leetcode.com/problems/4sum/">LeetCode 18: 4Sum</a>
     * @param nums   the array of integers
     * @param target the target sum
     * @return a list of quadruplets, each represented as a list of four integers,
     *         whose sum matches the target
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length < 4)
            return result;

        // First two numbers start from the beginning, third and fourth go inwards.
        for (int first = 0; first < nums.length - 2; first++) {
            // Taking care of duplicates. Same goes for second, third and fourth.
            if (first != 0 && nums[first] == nums[first - 1])
                continue;
            for (int second = first + 1; second < nums.length - 1; second++) {
                if (second != first + 1 && nums[second] == nums[second - 1])
                    continue;
                int third = second + 1;
                int fourth = nums.length - 1;
                while (third < fourth) {
                    // Int holding values between -2147483648 and 2147483647 isn't sufficient.
                    long sum = (long) nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (sum < target || third != second + 1 && nums[third] == nums[third - 1])
                        third++;
                    else if (sum > target || fourth != nums.length - 1 && nums[fourth] == nums[fourth + 1])
                        fourth--;
                    else {
                        result.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        third++;
                        fourth--;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Modifies the array in-place to generate the lexicographically next greater
     * permutation.
     * If no such permutation exists, it rearranges the array into the lowest
     * possible order (i.e., sorted in ascending order).
     *
     * @see <a href="https://leetcode.com/problems/next-permutation/">LeetCode 31:
     *      Next Permutation</a>
     * @param nums the array of integers
     */
    public void nextPermutation(int[] nums) {
        int i;
        int swapWith; // Position of element in nums that I will potentially swap with.

        // Must go right to left to find next smallest element.
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                swapWith = i + 1;
                // It's better to go right to left but this works.
                while (swapWith < nums.length - 1 && nums[swapWith + 1] > nums[i])
                    swapWith++;
                swap(nums, i, swapWith);
                reverse(nums, i + 1, nums.length - 1);
                return;
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    /**
     * Groups anagrams together from the given array of strings.
     * Anagrams are words or phrases formed by rearranging the letters of another
     * word or phrase,
     * using all the original letters exactly once. For example, "listen" and
     * "silent" are anagrams
     * of each other because they contain the same letters arranged in a different
     * order.
     *
     * @see <a href="https://leetcode.com/problems/group-anagrams/">LeetCode 49:
     *      Group Anagrams</a>
     * @param strs an array of strings
     * @return a list of lists where each inner list contains anagrams of each other
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> words = new HashMap<>();

        for (String s : strs) {
            char[] hashCode = new char[26];
            for (char c : s.toCharArray())
                hashCode[c - 'a'] += 1;

            StringBuilder encoded = new StringBuilder();
            for (char c : hashCode)
                encoded.append(c);
            String encodedWord = encoded.toString();

            if (words.containsKey(encodedWord))
                words.get(encodedWord).add(s);
            else {
                ArrayList<String> pattern = new ArrayList<>();
                pattern.add(s);
                words.put(encodedWord, pattern);
            }
        }

        return new ArrayList<>(words.values());
    }

    /**
     * Searches for a target value in a 2D matrix where each row is sorted in
     * ascending order
     * and the first element of each row is greater than the last element of the
     * previous row.
     * 
     * @see <a href="https://leetcode.com/problems/search-a-2d-matrix/">LeetCode 74:
     *      Search a 2D Matrix</a>
     * @param matrix the 2D matrix of integers
     * @param target the target value to search for
     * @return true if the target value is found in the matrix, false otherwise
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int numRows = matrix.length;
        int left = 0;
        int right = numRows - 1;
        int middle = (left + right) / 2;

        // Checking which row may contain target. If the first item in that row is
        // target, return true.
        while (left <= right) {
            middle = (left + right) / 2;
            if (matrix[middle][0] == target)
                return true;
            else if (middle == numRows - 1
                    || matrix[middle][0] < target && middle + 1 < numRows && matrix[middle + 1][0] > target)
                break;
            else if (matrix[middle][0] < target)
                left = middle + 1;
            else
                right = middle - 1;
        }

        // Now search inside that row to see if it is there.
        left = 0;
        right = matrix[middle].length - 1;
        while (left <= right) {
            int element = (left + right) / 2;
            if (matrix[middle][element] == target)
                return true;
            else if (matrix[middle][element] < target)
                left = element + 1;
            else
                right = element - 1;
        }
        return false;
    }

    /**
     * Generates all possible subsets of the given array of integers.
     * 
     * @see <a href="https://leetcode.com/problems/subsets/">LeetCode 78:
     *      Subsets</a>
     * @param nums the array of integers
     * @return a list containing all subsets of the input array
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        tryPosition(nums, 0, path, ans);
        return ans;
    }

    /**
     * Recursively explores all possible subsets starting from the specified
     * position.
     * This is a helper private method used by the {@link #subsets(int[])} method.
     * 
     * @param nums          the array of integers
     * @param startingPoint the starting index to begin exploring subsets
     * @param path          the current subset being explored
     * @param ans           the list to store all generated subsets
     */
    private void tryPosition(int[] nums, int startingPoint, List<Integer> path, List<List<Integer>> ans) {
        // Add a copy of the current path! Path will change over time.
        ans.add(new ArrayList<>(path));

        for (; startingPoint < nums.length; startingPoint++) {
            path.add(nums[startingPoint]);
            tryPosition(nums, startingPoint + 1, path, ans);
            // If I remove nums[startingPoint], it will remove its first occurrence.
            // However, I want to remove the last occurrence!
            path.remove(path.size() - 1);
        }
    }

    /**
     * Merges two sorted arrays into the first array, nums1, where nums1 has enough
     * space
     * to accommodate all elements from both arrays. Both input arrays, nums1 and
     * nums2, are sorted in non-decreasing order.
     * 
     * @see <a href="https://leetcode.com/problems/merge-sorted-array/">LeetCode 88:
     *      Merge Sorted Array</a>
     * @param nums1 the first sorted array of integers
     * @param m     the number of elements in nums1 (excluding additional allocated
     *              space)
     * @param nums2 the second sorted array of integers
     * @param n     the number of elements in nums2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptrNums1 = m - 1;
        int ptrNums2 = n - 1;
        int curr = m + n - 1;

        // Merging elements from nums1 and nums2 into nums1 starting from the end of
        // both arrays.
        while (ptrNums1 > -1 && ptrNums2 > -1)
            nums1[curr--] = (nums1[ptrNums1] > nums2[ptrNums2]) ? nums1[ptrNums1--] : nums2[ptrNums2--];

        // If there are remaining elements in nums2, add them to nums1.
        while (ptrNums2 > -1)
            nums1[curr--] = nums2[ptrNums2--];
    }

    /**
     * Finds the length of the longest consecutive sequence of integers in the given
     * array.
     * 
     * @param nums an array of integers
     * @return the length of the longest consecutive sequence of integers
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        HashSet<Integer> arr = new HashSet<Integer>();
        int ans = 1;

        for (int num : nums)
            arr.add(num);

        for (int num : nums) {
            // This makes this solution O(n): I only compute the length of the sequence at
            // its end. In the worst case, I only go through every element twice.
            if (arr.contains(num + 1))
                continue;
            int count = 1;
            while (arr.contains(--num))
                count++;
            // I can also do Math.max(ans, count)
            ans = (count > ans) ? count : ans;
        }
        return ans;
    }

    /**
     * Computes the product of all elements in the array except for the current
     * element.
     * The solution computes the prefix products and postfix products to efficiently
     * calculate the result.
     * 
     * @param nums an array of integers
     * @return an array where each element at index i contains the product of all
     *         elements in nums except nums[i]
     */
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];

        // Store prefix up until nums[i] in prefix[i-1].
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            prefix[i] = prefix[i - 1] * nums[i];

        int postfix = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            prefix[i] = prefix[i - 1] * postfix;
            postfix *= nums[i];
        }

        prefix[0] = postfix;
        return prefix;
    }

}

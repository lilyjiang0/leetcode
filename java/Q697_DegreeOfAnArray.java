package java;

import java.util.HashMap;
import java.util.Map;

/* Array
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined 
 * as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, 
 * that has the same degree as nums.
 * 
 * Constraints:
 *  nums.length will be between 1 and 50,000.
 *  nums[i] will be an integer between 0 and 49,999.
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: nums.length = 1, nums.length = 50000
 * 4. edge cases: nums[i] = 0, nums[i] = 49999
 * 5. nums has multiple elements of the same degree.
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

/* Use hashmap to store a int array of degree, first and last index info.
 * https://leetcode.com/problems/degree-of-an-array/solutions/108650/easy-understand-java-solution-beats-100-solutions/
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                // First is degree, second is first index, last is the last index.
                map.put(nums[i], new int[]{1, i, i});
            } else {
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
            }
        }
        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int[] val : map.values()) {
            if (val[0] > degree) {
                res = val[2] - val[1] + 1;
                degree = val[0];
            } else if (val[0] == degree) {
                res = Math.min(val[2] - val[1] + 1, res);
            }
        }
        return res;
    }
}

/* Two hashmap and one loop solution. Longer runtime than solution1.
 * https://leetcode.com/problems/degree-of-an-array/solutions/124317/java-c-python-one-pass-solution/
 */
class Solution2 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(); // Count degree.
        Map<Integer, Integer> first = new HashMap<>(); // Record first index.
        int res = 0;
        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            first.putIfAbsent(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);

            if (count.get(nums[i]) > degree) {
                degree = count.get(nums[i]);
                res = i - first.get(nums[i]) + 1;
            } else if (count.get(nums[i]) == degree) {
                res = Math.min(res, i - first.get(nums[i]) + 1);
            }
        }
        return res;
    }
}
package java;

import java.util.HashMap;
import java.util.Map;

/* Array & Hash-Table
Given an array of integers nums and an integer target, return indices of the 
two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not 
use the same element twice.

You can return the answer in any order. */

/* Test cases: 
 * 1. normal
 * 2. nums = null 
 * 3. nums with long length
 * 4. nums with negative integers
 * 5. nums with large integers
 * 6. empty nums
*/

/* Brute force.
 * Time complexity: O(n^2)
 * Space complexity: O(n)
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}


/* Two pass hash table.
 * Time complexity: O(n)
 * Space complecity: O(n)
 * Extra white box test cases: 
 * 1. same numbers. [3, 3, 4, 5], 6; output = [0,1]
 */
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        // Turn nums into a hashmap.
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int complement = target - nums[j];
            // Find complement.
            if (numsMap.containsKey(complement)
                && numsMap.get(complement) != j) {
                return new int[] {j, numsMap.get(complement)};
            }
        }
        return null;
    }
}


/* One pass hash table
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Extra white box test cases: 
 * 1. same numbers. [3, 3], 6; output = [0,1]
 */
class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        // Turn nums into a hashmap.
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Find complement.
            if (numsMap.containsKey(complement)) {
                return new int[] {i, numsMap.get(complement)};
            }
            // Put at the end to aviod getting the number itself.
            numsMap.put(nums[i], i);
        }
        return null;
    }
}
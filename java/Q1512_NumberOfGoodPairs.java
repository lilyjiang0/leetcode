package java;

import java.util.HashMap;

/* Array, Hash Table, Math, Counting
 * Given an array of integers nums, return the number of good pairs.
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 * 
 * Constraints:
 *  1 <= nums.length <= 100
 *  1 <= nums[i] <= 100
 * 
 * Test cases:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: nums.length = 1, nums.length = 100
 * 4. edge cases: nums[i] = 1, nums[i] = 100
 * 5. all same number, all different number
 */

/* Hashmap solution.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int res = 0;

        for (int n : nums) {
            // Get value for key n, or get 0.
            int val = count.getOrDefault(n, 0);
            // Increment result. 1 instance +0, 2 instance +1, 3 instance +2.
            // 1 instance = 0, 2 instance = 0+1, 3 instance = 0+1+2
            res += val;
            // Increment and store value to right key.
            count.put(n, val+1);
            
        }
        return res;
    }
}

/* Array solution.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution2 {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        // Use 101 as the maximum of nums.length is 100.
        int[] count = new int[101];
        for (int n : nums) {
            res += count[n];
            count[n]++;
            
        }
        return res;
    }
}

/* Brute Force.
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
class Solution3 {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                // For each number, loop through the entire array again to check the condition.
                if (nums[i] == nums[j] && (i < j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
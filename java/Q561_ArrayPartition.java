package java;

import java.util.Arrays;

/* Array.
 * Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), 
 * (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return 
 * the maximized sum.
 * 
 * Constraints:
 *  1 <= n <= 104
 *  nums.length == 2 * n
 *  -104 <= nums[i] <= 104
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: nums.length = 2, nums.length = 208
 * 4. edge cases: nums[i] = -104, nums[i] = 104
 * 5. nums[i] are all same, nums[i] are all zero
 * 
 * Time complexity: O(nlog(n)) // because Arrays.sort() has O(nlog(n)) complexity.
 * Space complexity: O(1)
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}

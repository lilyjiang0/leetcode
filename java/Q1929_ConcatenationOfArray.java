package java;

/* Array
 * Given an integer array nums of length n, you want to create an array ans of length 2n 
 * where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 * Specifically, ans is the concatenation of two nums arrays.
 * Return the array ans.
 * 
 * Constraints:
 *  n == nums.length
 *  1 <= n <= 1000
 *  1 <= nums[i] <= 1000
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: n = 1, n = 1000
 * 4. edge cases: nums[i] = 1, nums[i] = 1000
 */

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
            // Shorter statement:
            // ans[i] = ans[i + n] = nums[i];
        }
        return ans;
    }
}

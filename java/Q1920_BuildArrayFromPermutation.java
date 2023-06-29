package java;

/* Array, Simulation
 * Given a zero-based permutation nums (0-indexed), build an array ans of the same length where 
 * ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
 * A zero-based permutation nums is an array of distinct integers from 0 
 * to nums.length - 1 (inclusive).
 * Constraints:
 *  1 <= nums.length <= 1000
 *  0 <= nums[i] < nums.length
 *  The elements in nums are distinct.
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. nums.length = 1, nums.length = 1000
 * 4. nums[i] = 0, nums[i] = nums.length - 1
 */

/* Solution without using extra space.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // Use Euclid's Division algorithm a = r + bq, to keep both old and new value.
            // example of [5,0,1,2,3,4]
            // nums[0] = 5 + 6 * (4 % 6) = 29
            // new value = 29 / 6 = 4 (divisor), old value = 29 % 6 = 5 (remainder).
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }

        for (int i = 0; i < n; i++) {
            // Replace old value with new value.
            nums[i] = nums[i] / n;
        }

        return nums;
    }
}

/* Simple solution.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution2 {
    public int[] buildArray(int[] nums) {
        // Initialise a new array to store the output.
        int[] out = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // Build the array.
            out[i] = nums[nums[i]];
        }


        return out;
    }
}

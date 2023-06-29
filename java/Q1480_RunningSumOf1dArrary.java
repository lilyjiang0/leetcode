package java;


/* Array, Prefix Sum
 * Given an array nums. We define a running sum of 
 * an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 * 
 * Constraints:
 *  1 <= nums.length <= 1000
 *  -10^6 <= nums[i] <= 10^6
 *  
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: nums.length = 1, nums.length = 1000.
 * 4. edge cases: nums[i] = -10^6, nums[i] = 10^6
 */

/* Not modifying value of nums. 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[0] = nums[0];
            } else {
                result[i] = result[i - 1] + nums[i];
            }
        }
        return result;
    }
}

/* Modifying value of nums. 
 * Time complexity: O(n)
 * Space complexity: O(1)
 * 
 */
class Solution2 {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }

}
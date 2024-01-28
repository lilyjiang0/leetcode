package java;

/* Array
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * 
 * Constraints:
 *  1 <= nums.length <= 105
 *  nums[i] is either 0 or 1.
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: nums.length = 1, nums.length = 105
 * 4. All nums[i] = 0, all nums[i] = 1.
 * 5. there are multiple occurrence of max number of consecutive 1.
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

 /* My solution.
  */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConOnes = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;
            }
            // Check the sum when reaches a zero or the end.
            if (nums[i] == 0 || i == nums.length - 1) {
                maxConOnes = Math.max(sum, maxConOnes);
                sum = 0;
            } 
        }
        return maxConOnes;
    }
}

/* No if solution.
 * https://leetcode.com/problems/max-consecutive-ones/solutions/96807/concise-java-solution-without-if/
 */
class Solution2 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxSum = 0, sum = 0;
        for (int n : nums) {
            // When there is a zero, sum will reset to zero.
            sum *= n;
            sum += n;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
package java;

/* Array, Two Pointers.
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
 * The order of the elements may be changed. Then return the number of elements in nums which 
 * are not equal to val
 * 
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, 
 * you need to do the following things:
 * 
 * 1. Change the array nums such that the first k elements of nums contain the elements which are 
 * not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * 2. Return k.
 * 
 * Constraints:
 *  0 <= nums.length <= 100
 *  0 <= nums[i] <= 50
 *  0 <= val <= 100
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: nums.length = 0, nums.length = 100
 * 4. edge cases: nums[i] = 0, nums[i] = 50
 * 6. edge cases: val = 0, val = 100
 * 7. all elements in nums = val
 * 8. occurrences of val at nums[0], nums[nums.length - 1]
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

/* My solution.
 * Two pointers.
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int moveIndex = 0;
        // Find all array values != val and move it to the front.
        for (int num : nums) {
            if (num != val) {
                nums[moveIndex] = num;
                moveIndex++;
            } 
        }
        return moveIndex;
    }
}
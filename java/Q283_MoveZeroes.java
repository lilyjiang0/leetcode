package java;

/* Array, Two pointers.
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order 
 * of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * Constraints:
 *  1 <= nums.length <= 104
 *  -231 <= nums[i] <= 231 - 1
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: nums.length = 1, nums.length = 104
 * 4. edge cases: nums[i] = -231, nums[i] = 231 - 1
 * 5. all zeros, all non zeros
 * 6. zero at the start, zero at the end
 */

/* My Solution. Find zeros and change it with non-zeros.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++, j++) {
            if (nums[i] == 0) {
                // Find next non zero.
                while (nums[j] == 0 && j < nums.length - 1) {
                    j++;
                }
                
                nums[i] = nums[j];
                nums[j] = 0;

                // End if there are no more non zero.
                if (j == nums.length - 1) {
                    break;
                }
            }
        }
    }
}

/* Shift non zero to left and replace the rest with zero.
 * https://leetcode.com/problems/move-zeroes/solutions/4218030/java-1ms-beats-100/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution2 {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int nonZeroIndex = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[nonZeroIndex] = num;
                nonZeroIndex++;
            }
        }

        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }
    }
}

/* Snowball solution.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution3 {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int snowballSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowballSize++;
            } else if (snowballSize > 0) {
                nums[i - snowballSize] = nums[i];
                nums[i] = 0;
            }
        }
    }
}

/* Find non zero and change it with zero on its left.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution4 {
    public void moveZeroes(int[] nums) {
        int leftZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > leftZeroIndex) {
                    nums[leftZeroIndex] = nums[i];
                    nums[i] = 0;
                }
                leftZeroIndex++;
            }
        }
    }
}
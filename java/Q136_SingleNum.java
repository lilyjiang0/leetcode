package java;

import java.util.Arrays;

/* Hash table, bit manipulation
 * Given a non-empty array of integers nums, every element appears twice except 
 * for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only 
 * constant extra space.
 * 
 * Assumption: Each element in the array appears twice except for one element which appears only once.
 */

 /* sort: INCORRECT, not linear runtime complexity
  * Time complexity: O(n) + O(nlog(n))
  * Space complexity: O(1)
  *
  * Test:
  * 1. Normal cases
  * 2. null array
  * 3. length 1 array
  * 4. long array
  */
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            // Reach the end.
            // Single number not found until the last num, then the last is single
            if (i + 1 >= nums.length) {
                return nums[i];
            }
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }

        }
        return 0;
    }
}


 /* XOR, bit
  * Time complexity: O(n)
  * Space complexity: O(1)
  *
  * Test:
  * 1. Normal cases
  * 2. null array
  * 3. length 1 array
  * 4. long array
  */
class Solution2 {
    public int singleNumber(int[] nums) {
        // 2, 2, 1
        // 2 = 010, 1 = 001
        // 1 XOR 0 = 1, 0 XOR 0 = 0, so n XOR 0 = n, 0 can be ignored. (1)
        // There are always an even number of duplicates -> even num of 1s, 
        // 1 XOR 1 = 0; Then use (1) we know the result must be n itself.
        int result = 0; 
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
package java;

/* array | dynamic-programming
 * Given an integer array nums, move all the even integers at the beginning of the array followed 
 * by all the odd integers.
 * 
 * Return any array that satisfies this condition.
 * 
 * Constraints:
 *  1 <= nums.length <= 5000
 *  0 <= nums[i] <= 5000
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: nums.length = 1, nums.length = 5000
 * 4. edge cases: nums[i] = 0, nums[i] = 5000
 * 6. nums that already satisfies the condition.
 * 7. all nums[i] are even/odd integers.
*/

/* Avoid in place swapping.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int[] sortArrayByParity(int[] nums) {    
        int[] out = new int[nums.length];
        int evenIndex = 0;
        int oddIndex = nums.length - 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                out[evenIndex] = num;
                evenIndex++;
            } else {
                out[oddIndex] = num;
                oddIndex--;
            }
        }

        return out;
    }
}

/* In place swapping.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution2 {
    public int[] sortArrayByParity(int[] nums) {
        // Index to track the position of the next even element
        int evenIndex = 0;  
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                // Swap the current element with the next available even-indexed position
                swap(nums, i, evenIndex++);
            }
        }
        
        // Return the sorted array
        return nums;  
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
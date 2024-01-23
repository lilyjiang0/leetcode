package java;

/* Array, Math, Bit manipulation.
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number 
 * in the range that is missing from the array.
 * 
 * Constraints:
 *  n == nums.length
 *  1 <= n <= 104
 *  0 <= nums[i] <= n
 *  All the numbers of nums are unique.
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: n = 1, n = 104
 * 4. edge cases: missing the largest/ smallest number
 */

/* My solution.
 */
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return expectedSum - sum;
    }
}

/* XOR solution.
 * https://leetcode.com/problems/missing-number/solutions/69791/4-line-simple-java-bit-manipulate-solution-with-explaination/
 * The basic idea is to use XOR operation. We all know that a^b^b =a, which means two xor 
 * operations with the same number will eliminate the number and reveal the original number.
 * In this solution, I apply XOR operation to both the index and value of the array. In a complete 
 * array with no missing numbers, the index and value should be perfectly corresponding
 * ( nums[index] = index), so in a missing array, what left finally is the missing number.
 */
class Solution2 {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i=0; i < nums.length; i++){
            res = res ^ i ^ nums[i]; // a^b^b = a
        }
        return res;
    }
}
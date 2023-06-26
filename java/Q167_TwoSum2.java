package java;

/* Two Sum II - Input Array Is Sorted
 * array | two-pointers | binary-search
 * 
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing 
 * order, find two numbers such that they add up to a specific target number. Let these 
 * two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * 
 * Return the indices of the two numbers, index1 and index2, added by one as an integer 
 * array [index1, index2] of length 2.
 * 
 * The tests are generated such that there is exactly one solution. You may not use the 
 * same element twice.
 * 
 * Your solution must use only constant extra space.
 * 
 * Assumptions:
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 * 
 * Test cases:
 * 1. normal cases
 * 2. minimum and maximum numbers.length
 * 3. minimum and maximum target
 */

/* Brute force.
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {i + 1, j + 1};

                }
            }
        }
        return null;
    }
}

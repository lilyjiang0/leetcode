package java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* Array.
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all 
 * the integers in the range [1, n] that do not appear in nums.
 * 
 * Constraints:
 *  n == nums.length
 *  1 <= n <= 105
 *  1 <= nums[i] <= n
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: n = 1, n = 105
 * 4. edge cases: nums[i] = 1, nums[i] = 105
 * 5. large array, with only one non missing val
 * 6. large array, with only one missing val
 */

/* Set solution.
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/solutions/3108814/java-best-solution-o-n-time-complexity/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // Convert it into a set.
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // Check if set contains each number.
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}

/* Negation solution.
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/solutions/777978/java-time-o-n-space-o-1/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution2 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }
}

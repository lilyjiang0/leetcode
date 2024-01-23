package java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* Array, Hash Table.
 * Given an integer array nums, return true if any value appears at least twice in the array, 
 * and return false if every element is distinct.
 * 
 * Constraints:
 *  1 <= nums.length <= 105
 *  -109 <= nums[i] <= 109
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: nums.length = 1, nums.length = 105
 * 4. nums[i] = -109, nums[i] = 109
 * 5. long distance between two repeat integer
 * 6. repeat integer are adjacent to each other
 */

/* My solution. Compare size with set.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        return nums.length != set.size();
    }
}

/* Brute force.
 * https://leetcode.com/problems/contains-duplicate/solutions/3672475/4-method-s-c-java-python-beginner-friendly/
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}

/* Sort and check adjacent elements.
 * https://leetcode.com/problems/contains-duplicate/solutions/3672475/4-method-s-c-java-python-beginner-friendly/
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
class Solution3 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }
}

/* Set solution. Less time and space complexity version. 
 * Return when the element is found contained in the set while looping.
 * https://leetcode.com/problems/contains-duplicate/solutions/3672475/4-method-s-c-java-python-beginner-friendly/
 * Time complexity: O(n)
 * Space complexity: O(n) worst case
 */
class Solution4 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}

/* Hashmap solution.
 * https://leetcode.com/problems/contains-duplicate/solutions/3672475/4-method-s-c-java-python-beginner-friendly/
 * Time complexity: O(n)
 * Space complexity: O(n) worst case
 */
class Solution5 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int num : nums) {
            if (seen.containsKey(num) && seen.get(num) >= 1)
                return true;
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }
        return false;
    }
}
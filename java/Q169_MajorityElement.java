package java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Array, Divide and Conquer, Bit Manipulation.
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ 
 * times. 
 * 
 * Assumption: the majority element always exists in the array.
 * 1 <= nums.length <= 5 * 104
 */


/* Brute Force.
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 * 
 * Test cases:
 * 1. normal cases
 * 2. large array
 * 3. length 1 array
 * 4. negative integer
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        int major = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return nums[i];
            } else {
                count = 0;
            }
        }
        return major;
    }
}

/* Sorting, because majority element appear more than n/2 time.
 * Time complexity: O(n log(n)) // ref: https://stackoverflow.com/questions/71496763/what-is-the-worst-case-time-complexity-of-java-14-arrays-sort-int
 * Space complexity: O(1) / O(n)
 * 
 * Test cases:
 * 1. normal cases
 * 2. large array
 * 3. length 1 array
 * 4. negative integer
 * 5. worst case complexity
 * 
 */
class Solution2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}



/* Hashmap
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 * Test cases:
 * 1. normal cases
 * 2. large array
 * 3. length 1 array
 * 4. negative integer
 */
class Solution3 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map  = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                // key not exist, create key
                map.put(nums[i], 1);
            } else {
                // key exist, then increment the value
                map.put(nums[i], map.get(nums[i]) + 1);
            }

            if (map.get(nums[i]) > nums.length / 2) {
                // Find majority value.
                result = nums[i];
                break;
            }
        }
        return result;
    }
}


/* Moore voting algothrim.
 * Time complexity: O(n)
 * Space complexity: O(1)
 * 
 * Test cases:
 * 1. normal cases
 * 2. large array
 * 3. length 1 array
 * 4. negative integer
 * 5. different order of elements
 */
class Solution4 {
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) { // get next candidate.
                result = num;
            }
            if (result != num) {
                count--;
            } else {
                count++;
            }
        
        }
        return result;
    }
}


/* TODO: bit manipulation technique
 * Time complexity: 
 * Space complexity: 
 * 
 * Test cases:
 * 1. normal cases
 * 2. large array
 * 3. length 1 array
 * 4. negative integer
 */
class Solution5 {
    public int majorityElement(int[] nums) {
        return 0;
    }
}
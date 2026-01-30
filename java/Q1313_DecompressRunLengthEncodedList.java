package java;

import java.util.ArrayList;
import java.util.List;

/* Array
We are given a list nums of integers representing a list compressed with run-length encoding.

Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).  
For each such pair, there are freq elements with value val concatenated in a sublist. Concatenate 
all the sublists from left to right to generate the decompressed list.

Return the decompressed list.

Constraints:
- 2 <= nums.length <= 100
- nums.length % 2 == 0
- 1 <= nums[i] <= 100

Time Complexity: O(n + m), n = nums.length / 2, m = sum of frequency
Space Complexity: O(m)

Test:
- Min and max length nums, 2 & 100.
- Min and max frequency, 1 & 100.
- Min and max value, 1 & 100;
- Repeat pairs in nums.
- Same number for freq and val.
- Big diff between freq and val.
- All pairs are the same.
- Max length and max frequency.
 */
// Use Arraylist and convert back to array. Greater runtime and memory.
class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList();
        // Because nums consists of pair of elements, use i += 2.
        for (int i = 0; i < nums.length; i += 2) {
            // Get and loop frequency.
            int j = nums[i];
            while (j > 0) {
                res.add(nums[i + 1]);
                j--;
            }
        }
        // Convert arraylist to array.
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}

// Calculate the total length first and use array to store result.
class Solution2 {
    public int[] decompressRLElist(int[] nums) {
        // Calculate total length by adding up frequency.
        int resultLen = 0;
        for (int i = 0; i < nums.length; i += 2) {
            resultLen += nums[i];
        }

        // Initialise the array with total length.
        int[] result = new int[resultLen];
        // Track result array index.
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            // Get and loop frequency.
            int j = nums[i];
            while (j > 0) {
                result[index] = nums[i + 1];
                index++;
                j--;
            }
        }
        return result;
    }
}
package java;

import java.util.ArrayList;
import java.util.List;

/* Array
Given two arrays of integers nums and index. Your task is to create target array under the 
following rules:

Initially target array is empty.
From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] 
in target array.
Repeat the previous step until there are no elements to read in nums and index.
Return the target array.

It is guaranteed that the insertion operations will be valid.

Constraints:
- 1 <= nums.length, index.length <= 100
- nums.length == index.length
- 0 <= nums[i] <= 100
- 0 <= index[i] <= i

Time Complexity: O(N^2)
Space Complexity: O(N)

Test:
- Min and max nums and index length, 1 & 100.
- Min and max num[i], 0 & 100.
- Worst case time complexity O(N^2), nums = [1,2,1,4,6], index = [0,0,0,0,0].
- All same index.
 */
// Arraylist solution.
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> res = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            // Insert element to index, shifts the element currently at that position 
            // if any and any subsequent elements to the right.
            res.add(index[i], nums[i]);
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
}

// Solution using only array. Better memory usage.
class Solution2 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > index[i]; j--) {
                result[j] = result[j - 1];
            }
            result[index[i]] = nums[i];
        }
        return result;
    }
}
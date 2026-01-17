package java;

/*
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
That is, for each nums[i] you have to count the number of valid j's such that j != i and 
Return the answer in an array.nums[j] < nums[i].

Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100

Time Complexity: O(n)
Space Complexity: O(1)

Test:
- Regular cases e.g. [3, 2, 8, 1, 10], [5, 2, 3]
- Edge cases: nums.length = 2, nums.length = 500, nums[i] = 0, nums[i] = 100.
- nums[i] are all equal.
- Some of nums[i] are equal.
- nums has ascending/ descending order.
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // Initialise an array to count nums[i], 
        // which has the value between 0 and 100.
        int[] count = new int[101];
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]] += 1;
        }

        // Add previous/smaller numbers.
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Loop through nums and assign result to it.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // For 0, there is no smaller numbers.
                nums[i] = 0;
            } else {
                // Use the previous value because we don't
                // count number with the same value.
                nums[i] = count[nums[i] - 1];
            }
        }
        return nums;
    }
}

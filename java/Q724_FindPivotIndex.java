package java;

/* Array
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the left of the 
 * index is equal to the sum of all the numbers strictly to the index's right.
 * 
 * If the index is on the left edge of the array, then the left sum is 0 because there are 
 * no elements to the left. This also applies to the right edge of the array.
 * 
 * Return the leftmost pivot index. If no such index exists, return -1.
 * 
 * Constraints:
 *  1 <= nums.length <= 10^4
 *  -1000 <= nums[i] <= 1000
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: nums.length = 1, nums.length = 10^4
 * 4. edge cases: nums[i] = -1000, nums[i] = 1000
 * 5. index on the left/ right edge.
 * 6. a mix of positive and negative value for nums[i]
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

/* My solution.
 */
class Solution {
    public int pivotIndex(int[] nums) {
        // Get sum of all values in the array.
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int left = 0;
        int right = 0;
        int pivotIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            // Check if the current i is on the pivot index.
            // Value of two side = a, value of the pivot index = b.
            // sum = 2a + b
            // b = sum - 2a
            // So we can find b by checking its value.
            boolean isMiddle = (nums[i] == sum - 2 * left);
            if (pivotIndex != -1) {
                right += nums[i];
            } else if (isMiddle) {
                pivotIndex = i;
            } else if (!isMiddle) {
                left += nums[i];
            }
        }

        if (right == left) {
            return pivotIndex;
        }
        return -1;
    }
}

/* Same idea as mine but optimised. Return pivotIndex directly when found, no need to check if 
 * left = right when we find the pivotIndex. 
 * https://leetcode.com/problems/find-pivot-index/solutions/2470014/very-easy-100-fully-explained-java-c-python-js-python3/
 */
class Solution2 {
    public int pivotIndex(int[] nums) {
        // Initialize total sum of the given array...
        int totalSum = 0;
        // Initialize 'leftsum' as sum of first i numbers, not including nums[i]...
        int leftsum = 0;
        // Traverse the elements and add them to store the totalSum...
        for (int ele : nums)
            totalSum += ele;
        // Again traverse all the elements through the for loop and store the sum of i numbers 
        // from left to right...
        for (int i = 0; i < nums.length; leftsum += nums[i++])
            // sum to the left == leftsum.
            // sum to the right === totalSum - leftsum - nums[i]..
            // check if leftsum == totalSum - leftsum - nums[i]...
            if (leftsum * 2 == totalSum - nums[i])
                return i;       // Return the pivot index...
        return -1;      // If there is no index that satisfies the conditions 
    }
}

/*
 * https://leetcode.com/problems/find-pivot-index/solutions/2681701/java-easiest-solution-to-understand-100-faster/
 */
class Solution3 {
    public int pivotIndex(int[] nums) {
      int leftSum = 0, rightSum = 0;
      for (int num : nums) {
        rightSum += num;
      }

      for (int i = 0; i < nums.length; i++) {
        rightSum -= nums[i];
        if(rightSum == leftSum) {
            return i;
        }
        leftSum += nums[i];
      }
      return -1;
    }
}
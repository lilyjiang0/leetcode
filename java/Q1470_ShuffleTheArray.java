package java;

/* Array
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 * 
 * Constraints:
 *  1 <= n <= 500
 *  nums.length == 2n
 *  1 <= nums[i] <= 10^3
 * 
 * Test cases:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: n = 1, n = 500, nums[i] = 1, nums[i] = 10^3
 * 4. accounts[i][j] = 1, accounts[i][j] = 100
 * 5. null input
 */

/* No extra space.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                // Even index.
                // Use 1024, as the max nums[i] is 10^3.
                nums[i] = nums[i] + 1024 * (nums[i / 2] % 1024);
            } else {
                // Odd index.
                nums[i] = nums[i] + 1024 * (nums[n + i / 2] % 1024);
            }

        }
        for (int i = 0; i < nums.length; i++) {
            // Get the quotient out.
            nums[i] = nums[i] / 1024;
        }
        return nums;
    }
}

/* Two pointers.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution2 {
    public int[] shuffle(int[] nums, int n) {
        int[] out = new int[2 * n];
        
        int leftPointer = 0;
        int rightPointer = n;

        int index = 0;

        while (rightPointer < n * 2) {
            out[index] = nums[leftPointer];
            out[index + 1] = nums[rightPointer];

            index += 2;
            leftPointer++;
            rightPointer++;
        }
    
        return out;
    }
}

/* Loop n time.
 * Time complexity: O(n/2)
 * Space complexity: O(n)
 */
class Solution3 {
    public int[] shuffle(int[] nums, int n) {
        int[] out = new int[2 * n];
        for (int i = 0; i < n; i++) {
            out[2 * i] = nums[i];
            out[2 * i + 1] = nums[n + i];
        }
    
        return out;
    }
}

/* Loop 2n time.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution4 {
    public int[] shuffle(int[] nums, int n) {
        int[] out = new int[2 * n];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                out[i] = nums[i / 2];
            } else {
                out[i] = nums[n + i / 2];
            }
        }
        return out;
    }
}
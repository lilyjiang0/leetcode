package java;

/**
 * Given an integer num, return the number of steps to reduce it to zero.
 * In one step, if the current number is even, you have to divide it by 2, 
 * otherwise, you have to subtract 1 from it.
 * 
 * Constraints: 
 * - 0 <= num <= 10^6
 * 
 * Tests:
 * - Max num = 10^6.
 * - Min num = 0.
 * - Even/ odd num.
 * - Smallest even num 2.
 * - Smallest odd num 1.
 */
// Iterative solution. 
// Time complexity: O(steps)
// Space complexity: O(1)
class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num -= 1;
            }
            count++;
        }
        return count;
    }
}

// Recursive solution. 
// Time complexity: O(steps)
// Space complexity: O(steps) - because each recursive call must remain on the call stack until
// the base case is reached.
class Solution2 {
    public int numberOfSteps(int num) {
        return count(num, 0);
    }

    public int count(int num, int count) {
        if (num == 0) {
            return count;
        }
        if (num % 2 == 0) {
            return count(num / 2, count + 1);
        } else {
            return count(num - 1, count + 1);
        }
    }
}
package java;

/* dynamic-programming
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Constraints:
1 <= n <= 45

Time Complexity: O(n)
Space Complexity: O(1)

Test:
- Edge cases: n = 1, n = 45
- Normal cases: n = 2, n = 5
 */
// Bottom up dynamic programming. Starts from the bottom base case.
// Fibonacci numbers.
class Solution {
    public int climbStairs(int n) {
        int one = 1;
        int two = 1;
        int i = 0;

        while (i < n - 1) {
            int temp = one;
            one = one + two;
            two = temp;
            i++;
        }
        return one;
    }
}
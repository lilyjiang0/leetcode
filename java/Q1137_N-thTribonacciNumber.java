package java;

/* Array
 * The Tribonacci sequence Tn is defined as follows: 
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * 
 * Given n, return the value of Tn.
 * 
 * Constraints:
 *  0 <= n <= 37
 *  The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: n = 0, n = 37
 */
class Solution {
    public int tribonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 1;

        if (n < 2) {
            return n;
        }

        int result = 0;
        while (n > 2) {
            result = a + b + c;
            a = b;
            b = c;
            c = result;
            n--;
        }
        return c;
    }

}

/* Array
 */
class Solution2 {
    public int tribonacci(int n) {
        int dp[] = {0, 1, 1};
        for (int i = 3; i <= n; ++i) {
            dp[i % 3] = dp[0] + dp[1] + dp[2];
        }
        return dp[n % 3];
    }
}
// @lc code=end

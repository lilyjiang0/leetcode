package java;

/* Array, Matrix
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the 
 * i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.
 * A customer's wealth is the amount of money they have in all their bank accounts. The richest 
 * customer is the customer that has the maximum wealth.
 * 
 * Constraints:
 *  m == accounts.length
 *  n == accounts[i].length
 *  1 <= m, n <= 50
 *  1 <= accounts[i][j] <= 100
 * 
 * Test cases:
 * 1. normal cases
 * 2. large m, small n
 * 3. edge cases: m = 1, n = 50
 * 4. accounts[i][j] = 1, accounts[i][j] = 100
 * 5. null input
 */

/* 
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                wealth += accounts[i][j];
            }

            if (wealth > max) {
                max = wealth;
            }
            // Alternative: use Math module to get the maximum out of two.
            // Better memory usage.
            // max = Math.max(wealth, max);
        }
        return max;
    }
}

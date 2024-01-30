package java;

/* Array, Dynamic Programming.
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a 
 * different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. 
 * If you cannot achieve any profit, return 0.
 * 
 * Constraints:
 *  1 <= prices.length <= 10^4
 *  0 <= prices[i] <= 10^4
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: prices.length = 1, prices.length = 10^4
 * 4. edge cases: prices[i] = 0, prices[i] = 10^4
 * 5. consecutive decreasing/ increasing prices
 * 6. multiple maximum profit, same number
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

/* My solution. Look for the current minimum number and the biggest number after the current 
 * minimum, calculate the profit when the next minimum number is found and update the profit only 
 * when the it is greater.
 * Can be further optimised.
 */
class Solution {
    public int maxProfit(int[] prices) {
        int min = 10 * 10 * 10 * 10; // Constraint limit.
        int max = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            // Find bigger value than the current min.
            if (prices[i] > min) {
                // Update the max if bigger than the current max.
                max = Math.max(prices[i], max);
            }

            // Update min when a smaller value is found.
            if (prices[i] < min || i == prices.length - 1) {
                // Update profit if there is a larger and valid value.
                profit = Math.max(max - min, profit);
                min = prices[i];
                max = 0; // Reset max.
            }
        }
        return profit;
    }
}

/* Better runtime but worse memory solution than mine. Because of less if statement but 
 * more calculations.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solutions/3914105/most-optimized-solution-easy-to-understand-c-java-python/
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        int min = 10 * 10 * 10 * 10;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            // if (prices[i] > min) {
                profit = Math.max(prices[i] - min, profit);
            // } else {
                min = Math.min(prices[i], min);
            // }
        }
        return profit;
    }
}

/* Kadane's Algorithm
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solutions/39038/kadane-s-algorithm-since-no-one-has-mentioned-about-this-so-far-in-case-if-interviewer-twists-the-input/
 * A more clear explanation on why sum of subarray works.:
 * Suppose we have original array:
 * [a0, a1, a2, a3, a4, a5, a6]
 * 
 * what we are given here(or we calculate ourselves) is:
 * [b0, b1, b2, b3, b4, b5, b6]
 * 
 * where,
 * b[i] = 0, when i == 0
 * b[i] = a[i] - a[i - 1], when i != 0
 * 
 * suppose if a2 and a6 are the points that give us the max difference (a2 < a6)
 * then in our given array, we need to find the sum of sub array from b3 to b6.
 * 
 * b3 = a3 - a2
 * b4 = a4 - a3
 * b5 = a5 - a4
 * b6 = a6 - a5
 * 
 * adding all these, all the middle terms will cancel out except two i.e.
 * b3 + b4 + b5 + b6 = a6 - a2
 * a6 - a2 is the required solution.
 * so we need to find the largest sub array sum to get the most profit
 */
class Solution3 {
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
package java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* Hash table.
 * Given two integers left and right, return the count of numbers in the inclusive range 
 * [left, right] having a prime number of set bits in their binary representation.
 * 
 * Recall that the number of set bits an integer has is the number of 1's present 
 * when written in binary.
 * 
 * For example, 21 written in binary is 10101, which has 3 set bits.
 * 
 * Constraints:
 *  1 <= left <= right <= 10^6
 *  0 <= right - left <= 10^4
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: left = 1, right = 1, left = 10^6, right = 10^6
 * 4. edge cases: right - left = 0, right - left = 10^4
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
/* Loop through each integers and count their number of set bits.
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/solutions/113227/java-c-clean-code/
 */
class Solution {
    public int countPrimeSetBits(int left, int right) {
        // The constraint of <= 10^6, meaning their bit representations will 
        // have up to 20 symbols (10^6 < 2^20)
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        int res = 0;
        for (int i = left; i <= right; i++) {
            // Check whether it is a prime count.
            if (primes.contains(countBits(i))) {
                res++;
            }
        }
        return res;
    }

    private int countBits(int n) {
        int count = 0;
        // Iterate through each bit. Shift to the right after each iteration.
        for (int i = n; i > 0; i >>= 1) {
            // e.g. 1010 & 1 = 0 (1010 & 0001)
            // 101 & 1 = 1 (101 & 001)
            count += i & 1;
        }
        return count;
    }

}
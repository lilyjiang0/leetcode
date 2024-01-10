package java;

/*
 * Given an integer number n, return the difference between the product of its digits and the sum 
 * of its digits.
 * 
 * Constraints:
 *  1 <= n <= 10^5
 * 
 * Tests:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: n = 1, n = 10^5
 * 4. four same digits, four completely different digits.
 */

 /* Modulo approach.
  * Time complexity: O(log(n)) (why: https://stackoverflow.com/questions/2307283/what-does-olog-n-mean-exactly)
  * Space complexity: O(1)
  */
 class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            product *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return product - sum;
    }
}

/* String approach.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution2 {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        String s = Integer.toString(n);
        for (char c : s.toCharArray()) {
            // In the ASCII table, the character '0' has a value of 48, and the characters 
            // '1' to '9' have consecutive values from 49 to 57.
            int digit = c - '0';
            product *= digit;
            sum += digit;
        }
        return product - sum;
    }
}
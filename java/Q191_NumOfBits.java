package java;

/* Bit Manipulation.
 * Write a function that takes an unsigned integer and returns the 
 * number of '1' bits it has (also known as the Hamming weight).
 * 
 * Note:
 * Note that in some languages, such as Java, there is no unsigned integer type. 
 * In this case, the input will be given as a signed integer type. It should 
 * not affect your implementation, as the integer's internal binary representation 
 * is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 */


 /* 
  * Time complexity: O(1) // 32 bit runs 32 times
  * Space complexity: O(1)
  *
  * Test:
  * 1. Normal cases
  * 2. 32 one
  * 3. 32 zero
  */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) { // use != instead of >, because there is no unsigned integer type in java, but we need to treat n as unsigned. != can take in negative value.
            result += (n & 1); // 0 if 0 & 1, 1 if 1 & 1.
            n = n >>> 1; // >>> unsigned shift, >> signed shift.
        }
        return result;
    }
}

 /* 
  * Time complexity: O(1)
  * Space complexity: O(1)
  */
public class Solution2 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) { // Times of loop depending on number of '1' bits.
            /* Example:
             * 10010001 (- 1)
             * 10010000 (& 10010001)
             * 10010000 (- 1)
             * 10001111 (& 10010000)
             * 10000000 (- 1)
             * 01111111 (& 10000000)
             * 00000000
             */
            n &= (n - 1); // n & (n-1) will elimate one 1 at a time.
            result += 1;
        }
        return result;
    }
}
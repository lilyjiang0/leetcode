package java;

/* Array, Sort
 * The complement of an integer is the integer you get when you flip all the 0's to 1's and all 
 * the 1's to 0's in its binary representation.
 * 
 * For example, The integer 5 is "101" in binary and its complement is "010" which is the 
 * integer 2. Given an integer n, return its complement.
 * 
 * Constraints:
 *  0 <= n < 109
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: n = 0, n = 109
 */

/* My solution
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int bitwiseComplement(int n) {
        // Convert n to binary.
        String binary = Integer.toBinaryString(n);
        int result = 0;
        char[] charArray = binary.toCharArray();

        // Loop and add the number.
        for (int i = charArray.length - 1, j = 0; i >= 0; i--, j++) {
            if (charArray[i] == '0') {
                result += Math.pow(2, j);
            }
        }
        
        return result;
    }
}

/* 
 * https://leetcode.com/problems/complement-of-base-10-integer/solutions/1665492/java-detailed-explanation-of-intution-bit-masking-bit-flip-5-approach/
 * Intution: Since we have to find the complement of a given decimal number in binary form, 
 * we will use the complement property which is N + Compliment(N) = 111....111.
 * 
 * For Example :
 * N = 5 => N = 101 , Compliment(N) = 010 => 101 + 010 = 111
 * N = 8 => N = 1000 , Compliment(N) = 0111 => 1000 + 0111 = 1111
 * N = 17 => N = 10001, Compliment(N) = 01110 => 10001 + 01110 = 11111 and so on....
 * So we need to find out a number just greater than N having all 1 bits and then subtract N from 
 * it to get the complement.
 * Example : for N=5(101) => 111 is the number just greater than 5 having all 1s. So, 
 * 111 - 101 = 010 (Compliment)
 * 
 * Explanation: let n = 5 and i=0, j=0
 * Iteration1 : (i=0 < n) => i = 0 + (2^0) = 1 (1) , j = 1
 * Iteration2 : (i=1 < n) => i = 1 + (2^1) = 3 (11) , j = 2
 * Iteration3 : (i=3 < n) => i = 3 + (2^2) = 7 (111) , j = 3
 * Iteration4 : (i=7 > n) => loop breaks
 * Compliment = i -n => 111 - 101 = 010
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution2 {
    public int bitwiseComplement(int n) {
        if(n == 0) {
            return 1;
        }
        
        int i = 0;
        int j = 0;
        
        while(i < n){
            i += Math.pow(2,j);
            j++;
        }
        
        return i - n;
    }
}

/* Bit manipulation
 * Explanation: Just replace the arithmetical operation into bit manipulation as i += Math.pow(2^j) 
 * can be replaced with i<<n | 1. Let n = 5 and i=0, j=0
 * 
 * Iteration1 : (i=0 < n) => i =0<<1 | 1 = 1 | 1 = 1
 * Iteration2 : (i=1 < n) => i = 1<<1 | 1 = 10 | 1 = 11 = 3
 * Iteration3 : (i=3 < n) => i = 3<<1 | 1 = 11<<1 | 1 = 110 | 1 = 111 = 7
 * Iteration4 : (i=7 > n) => loop breaks
 * Compliment = i -n => 111 - 101 = 010
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution3 {
    public int bitwiseComplement(int n) {
        if(n == 0) {
            return 1;
        }
        
        int i = 0;
        
        while(i < n) {
            i = i << 1 | 1;
        }
        
        return i ^ n;
    }
}

/*
 * Explanation: let n = 10 and i=1, j=0
 * Iteration1 : (i=1 < n) => i = 1 * 2 +1 = 3 (11)
 * Iteration2 : (i=3 < n) => i = 3 * 2 + 1 = 7 (111)
 * Iteration3 : (i=7 < n) => i = 7 * 2 + 1 = 15 (1111)
 * Iteration4 : (i=15 > n) => loop breaks
 * Compliment = i -n => 1111 - 1010 = 0101 => 101 = 5
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution4 {
    public int bitwiseComplement(int n) {           
        int i = 1;
        
        while(i < n) {
            i = i * 2 + 1;
        }
        
        return i - n;
    }
}
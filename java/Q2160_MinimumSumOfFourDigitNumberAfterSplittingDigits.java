package java;

import java.util.Arrays;

/* Math, Greedy, Sorting.
 * You are given a positive integer num consisting of exactly four digits. 
 * Split num into two new integers new1 and new2 by using the digits found 
 * in num. Leading zeros are allowed in new1 and new2, and all the digits
 * found in num must be used.
 * For example, given num = 2932, you have the following digits: two 2's, one 9 and one 3. 
 * Some of the possible pairs [new1, new2] are [22, 93], [23, 92], [223, 9] and [2, 329].
 * Return the minimum possible sum of new1 and new2.
 * 
 * Constraints:
 *  1000 <= num <= 9999
 *  
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: num = 1000, num = 9999
 */

/* Convert to int array.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int minimumSum(int num) {
        // Get each digit of num into int array.
        int[] array = new int[4];
        int counter = 0;
        while (num > 0) {
            array[counter] = num % 10;
            num /= 10;
            counter++;
        }
        // Sort by ascending.
        Arrays.sort(array);

        // Get sum of two digits. 
        // Since three digit + one digit is always larger than two digit + two digit.
        /*
         * @szp14 I'd like to explain it by weighted sum:
         * No matter whether you add 3-dight to 1-dight, or 2-dight to another 2-dight, 
         * actually you just compute a weighted sum of 4 given numbers
         * For example, given num=2392, if you choose 22+93, actually it's 2*10 + 2*1 + 9*10 +3*1; 
         * If you choose 223+9, actually it's 2*100+2*10+3*1+9*1
         * If you choose to add 3-dight to 1-dight, the weights are [100,10,1,1]; if you choose 
         * to add 2-dight to 2-dight, the weights are [10,1,10,1]. Note that the order of each 
         * weight doesn't matter (since you can pick numbers from the given 4 dights in any way). 
         * The smaller set of weights is obvious.
         */
        // Always put the smallest digit at front for minimum.
        int num1 = 10 * array[0] + array[2];
        int num2 = 10 * array[1] + array[3];
        int sum = num1 + num2;
        return sum;
    }
}

/* Convert to char array. Less efficient.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution2 {
    public int minimumSum(int num) {
        // Get each digit of num into int array.
        char[] array = (num + "").toCharArray();
        // Sort by ascending.
        Arrays.sort(array);

        // Get sum of two digits. 
        // Since three digit + one digit is always larger than two digit + two digit.
        // Always put the smallest digit at front for minimum.
        int num1 = Integer.parseInt("" + array[0] + array[2]);
        int num2 = Integer.parseInt("" + array[1] + array[3]);
        int sum = num1 + num2;
        return sum;
    }
}

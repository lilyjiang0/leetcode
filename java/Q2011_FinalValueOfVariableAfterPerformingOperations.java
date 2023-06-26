package java;

/* 
 * There is a programming language with only four operations and one variable X:
 * ++X and X++ increments the value of the variable X by 1.
 * --X and X-- decrements the value of the variable X by 1.
 * Initially, the value of X is 0.
 * Given an array of strings operations containing a list of operations, return the 
 * final value of X after performing all the operations.
 * 
 * Constraints:
 *  1 <= operations.length <= 100
 *  operations[i] will be either "++X", "X++", "--X", or "X--".
 *  
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: operations.length = 1, operations.length = 100
 * 4. large output, negative output, small output
 */

/* Optimised solution. Use of ASCII code.
 * Time complexity: O(n)
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int val = 0;
        // Loop through operations array.
        for (String op : operations) {
            // ASCII 43 = plus, 45 = minus.
            // For whether ++X, X++, --X and X--, the operation can be identified 
            // by the middle character.
            // Use 44 minus the + or - : 
            // 44 - + = 44 - 43 = 1, 
            // 44 - - = 44 - 45 = -1.
            val += 44 - op.charAt(1);
        }
        return val;
    }
}

/* Simple solution. Check operation strings.
 * Time complexity: O(n)
 * Space complexity: O(1)
 * 
 */
class Solution2 {
    public int finalValueAfterOperations(String[] operations) {
        int val = 0;
        // Loop through operations array.
        for (String op : operations) {
            // Check whether the operation is increments or decrements.
            if (op.equals("--X") || op.equals("X--")) {
                val -= 1;
            } else if (op.equals("++X") || op.equals("X++")) {
                val += 1;
            }

            // // Simpler:
            // if (op.charAt(1) == '-') {
            //     val -= 1;
            // } else {
            //     val += 1;
            // }
        
        }
        return val;
    }
}

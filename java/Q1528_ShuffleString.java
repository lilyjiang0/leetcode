package java;

import java.util.Arrays;

/** String, array.
 * You are given a string s and an integer array indices of the same length.
 * The string s will be shuffled such that the character at the ith position 
 * moves to indices[i] in the shuffled string.
 * 
 * Return the shuffled string.
 * 
 * Constraints:
 * - s.length == indices.length == n
 * - 1 <= n <= 100
 * - s consists of only lowercase English letters.
 * - 0 <= indices[i] < n
 * - All values of indices are unique.
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 * Tests:
 * - Max indices and s length = 100.
 * - Min indices and s length = 1.
 * - s consists of 26 English letters.
 * - indices has ascending/ descending order.
 * - s consists of repeat letters.
 */
// Char array solution.
class Solution {
    public String restoreString(String s, int[] indices) {
        char[] res = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            res[indices[i]] = s.charAt(i); 
        }
        return new String(res);
    }
}

// String builder solution. Longer runtime because of an extra for loop.
class Solution2 {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            // Fill string builder to avoid index out of bound exception.
            sb.append(' ');
        }
        for (int i = 0; i < s.length(); i++) {
            sb.setCharAt(indices[i], s.charAt(i));
        }
        
        return sb.toString();
    }
}
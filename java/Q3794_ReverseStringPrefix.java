package java;

/**
 * You are given a string s and an integer k.
 * Reverse the first k characters of s and return the resulting string.
 * 
 * Constraints:
 * - 1 <= s.length <= 100
 * - s consists of lowercase English letters.
 * - 1 <= k <= s.length
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 * Tests: 
 * - Max s length = 100.
 * - Min s length = 1.
 * - Max k and s length = 100.
 * - Min k and s length = 1.
 * - s = 100 and k = 1.
 * - Even k.
 * - Odd k.
 * - s consists of all same letters.
 * - s consists of all unique letters.
 */
class Solution {
    public String reversePrefix(String s, int k) {
        if (k == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < k; i++) {
            sb.setCharAt(i, s.charAt(k - 1 - i));
        }
        return sb.toString();
    }
}

class Solution2 {
    public String reversePrefix(String s, int k) {
        if (k == 1) {
            return s;
        }
        char[] arr = s.toCharArray();

        for (int i = 0; i < k / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[k - 1 - i];
            arr[k - 1 - i] = temp;
        }
        return new String(arr);
    }
}
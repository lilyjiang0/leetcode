package java;

import java.util.HashMap;
import java.util.Map;

/* Hash Table, String
 * Given a string s, find the first non-repeating character in it and return its index. 
 * If it does not exist, return -1.
 * 
 * Constraints:
 *  1 <= s.length <= 10^5
 *  s consists of only lowercase English letters.
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: s.length = 1, s.length = 10^5
 * 4. Case of returning -1.
 * 5. The first character repeat at the last index.
 * 6. Multiple/ only one non-repeating characters.
 */

/* Hash Map solution.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            // Store characters and amount in a hash map. 
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            // Check each character if they appear only once.
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        // Non-repeating character does not exist.
        return -1;
    }
}

/* Array solution.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution2 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            // Store characters and amount in an array. 
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            // Check each character if they appear only once.
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        // Non-repeating character does not exist.
        return -1;
    }
}

/* Indexof Solution.
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
class Solution3 {
    public int firstUniqChar(String s) {
        for (char c : s.toCharArray()) {
            int firstIndex = s.indexOf(c);
            int lastIndex = s.lastIndexOf(c);
            if (firstIndex == lastIndex) {
                return firstIndex;
            }
        }
        return -1;
    }
}
package java;

import java.util.HashMap;
import java.util.Map;

/* Hash-table, sort
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word 
 * or phrase, typically using all the original letters exactly once.
 * 
 * Assumptions: 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 * 
 * Test cases:
 * 1. normal case
 * 2. different length
 * 3. same character appears multiple times
 * 4. very short and long strings
 */


/* Alphabet bucket. Followup: not complicate with unicode characters.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { // Compare length.
            return false;
        }
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // Increment corresponding bucket.
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int num : alphabet) {
            if (num != 0) {
                return false;
            }
        }
        return true;
        
    }
}


/* Hashmap. Followup: not complicate with unicode characters.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            int count = map.getOrDefault(t.charAt(i), 0);
            if (count == 0) {
                return false;
            } else {
                map.put(t.charAt(i), count - 1);
            }
        }
        return true;
        
    }
}


/* Hashmap. Followup: complicate with unicode characters.
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 * 
 * q&a https://leetcode.com/problems/valid-anagram/solutions/66533/java-solution-hashmap-unicode-follow-up/?orderBy=most_votes
 * Question: I don't get why we need to use code points? why not use the characters 
 * themselves as keys in the hash table? hash tables can use any hashable objects 
 * as keys, so why not use the char directly?
 * Answer: A single unicode "character" might be multiple "char"s or bytes. Reordering 
 * those bytes doesn't necessarily produce an anagram in the semantic sense. The closet 
 * you can get is something like grapheme clustering: 
 * http://www.unicode.org/reports/tr29/#Grapheme_Cluster_Boundaries. If someone were to 
 * ask this in an interview, I'd definitely talk about graphemes, surrogate pairs, and 
 * variation selectors as they all complicate the meaning of "anagram".
 */
class Solution3 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        
        // String.codePointAt(int index) method to get the integer representation of a Unicode (as the key in the hash table).
        s.codePoints().forEach(code -> map.put(code, map.getOrDefault(code, 0) + 1));
        t.codePoints().forEach(code -> map.put(code, map.getOrDefault(code, 0) - 1));
        
        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
        
    }
}


/* Hashmap. Followup: not complicate with unicode characters.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution4 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (int num : map.values()) {
            if (num != 0) {
                return false;
            }
        }
        return true;
        
    }
}
package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* Array
 * Given a string array words, return an array of all characters that show up in all strings 
 * within the words (including duplicates). You may return the answer in any order.
 * 
 * Constraints:
 *  1 <= words.length <= 100
 *  1 <= words[i].length <= 100 
 *  words[i] consists of lowercase English letters.
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: words.length = 1, words.length = 100
 * 4. edge cases: words[i].length = 1, words[i].length = 100
 * 5. words[i] consists of character occurred > once
 * 6. there is no common characters
 * 7. all words[i] are the same
 */

/* Simple array solution.
 */
class Solution {
    public List<String> commonChars(String[] words) {
        int[] last = count(words[0]);
        for (int i = 1; i < words.length; i++) {
            last = intersection(last, count(words[i]));
        }
        List<String> out = new ArrayList<>();
        for (int j = 0; j < last.length; j++) {
            if (last[j] > 0) {
                char a = 'a';
                a += j;
                String c = String.valueOf(a);
                while (last[j] > 0) {
                    out.add(c);
                    last[j]--;
                }
            }
        }

        return out;
    }

    public int[] intersection(int[] a, int[] b) {
        int[] out = new int[26];
        for (int i = 0; i < 26; i++) {
            out[i] = Math.min(a[i], b[i]);
        }
        return out;
    }

    public int[] count(String s) {
        int[] out = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            out[index]++;
        }

        return out;
    }
}

/* Hashmap solution.
 */
class Solution2 {
    public List<String> commonChars(String[] words) {
        // Store the frequency of characters for each string.
        List<HashMap<Character,Integer>> list = new ArrayList<>();
        for(String s: words){
            HashMap<Character,Integer> map = new HashMap<>();
            for(char ch: s.toCharArray()){
                map.put(ch, map.getOrDefault(ch,0)+1);
            }
            list.add(map);
        }
        // Ex: TC1 would look something like this [{a=1, b=1, e=1, l=2},
        // {r=2, e=1, l=2, o=1}]

        List<String> ans = new ArrayList<>();
        for(char ch : list.get(0).keySet()) {
            // Take the key of the first map in string.
            int min = Integer.MAX_VALUE;
            // Just iterate over all the maps and get the min occurrence.
            for (HashMap<Character, Integer> map : list) {
                if (!map.containsKey(ch)) {
                // If map doesnt contain a key then we are sure that this particiular 
                // character is not common.
                    min = 0;
                    break;
                }
                min = Math.min(min, map.get(ch));
            }
            for (int i = 0; i < min; i++) {
            // Put the common chararcter in the ans list.
                ans.add(String.valueOf(ch));
            }
        }
        return ans;
    }
}
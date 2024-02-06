package java;

import java.util.ArrayList;
/* Hash table.
 * Given an array of strings words, return the words that can be typed using letters of the 
 * alphabet on only one row of American keyboard like the image below.
 * 
 * In the American keyboard:
 * the first row consists of the characters "qwertyuiop",
 * the second row consists of the characters "asdfghjkl", and
 * the third row consists of the characters "zxcvbnm".
 * 
 * Constraints:
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] consists of English letters (both lowercase and uppercase). 
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: words.length = 20, words.length = 1.
 * 4. edge cases: words[i].length = 1, words[i].length = 100
 * 5. letters are a mix of lower and upper cases
 * 6. Only the first/last letter is not matched with a row.
 * 7. All/ none of words[i] match.
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(n) worst case
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* My solution. Loop through every letter of each word, and check if it only used 
 * letters of one row. 
 */
class Solution {
    public String[] findWords(String[] words) {
        // Use strings to store the three rows.
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";
        ArrayList<String> resList = new ArrayList<>();

        for (String word : words) {
            Boolean first = true;
            Boolean second = true;
            Boolean third = true;
            String wordLower = word.toLowerCase();
            for (int j = 0; j < word.length(); j++) {
                // Loop through each letter and check it with each row.
                if (first && !firstRow.contains(wordLower.charAt(j) + "")) {
                    first = false;
                }
                if (second && !secondRow.contains(wordLower.charAt(j) + "")) {
                    second = false;
                }
                if (third && !thirdRow.contains(wordLower.charAt(j) + "")) {
                    third = false;
                }
            }
            // If any one row is satisfied, add to result list.
            if (first || second || third) {
                resList.add(word);
            }
        }

        return resList.toArray(new String[0]);
    }
}

/* Hashmap solution. Use hashmap to store the row for each alphabets. More memory usage than mine.
 * https://leetcode.com/problems/keyboard-row/solutions/97870/short-easy-java-with-explanation/
 */
class Solution2 {
    public String[] findWords(String[] words) {
        // Store corresponding row and alphabet into a hashmap.
        String[] rows = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                map.put(c, i);
            }
        }
        List<String> resList = new ArrayList<>();
        for (String word : words) {
            // Find row for the first letter.
            int index = map.get(word.toLowerCase().charAt(0));
            for (char c : word.toLowerCase().toCharArray()) {
                // Set row to -1 if row does not match.
                if (map.get(c) != index) {
                    index = -1;
                }
            }
            if (index != -1) {
                resList.add(word);
            }
        }

        return resList.toArray(new String[0]);
    }
}

/* Array solution. Use a size 26 array to store the rows for each alphabets. Better runtime.
 * https://leetcode.com/problems/keyboard-row/solutions/413352/easy-solution-using-java-beats-100-in-0ms/
 */
class Solution3 {
    public String[] findWords(String[] words) {
        int[] rows = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        List<String> resList = new ArrayList<>();
        for (String word : words) {
            // Find row for the first letter.
            int row = rows[word.toLowerCase().charAt(0) - 'a'];
            for (char c : word.toLowerCase().toCharArray()) {
                // Set row to -1 if row does not match.
                if (rows[c - 'a'] != row) {
                    row = -1;
                }
            }
            if (row != -1) {
                resList.add(word);
            }
        }
        // Convert to array and return.
        return resList.toArray(new String[0]);
    }
}
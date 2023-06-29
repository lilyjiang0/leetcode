package java;

import java.util.StringTokenizer;

/* Array, String
 * A sentence is a list of words that are separated by a 
 * single space with no leading or trailing spaces.
 * You are given an array of strings sentences, where each sentences[i] 
 * represents a single sentence.
 * Return the maximum number of words that appear in a single sentence.
 * 
 * Constraints:
 *  1 <= sentences.length <= 100
 *  1 <= sentences[i].length <= 100
 *  sentences[i] consists only of lowercase English letters and ' ' only.
 *  sentences[i] does not have leading or trailing spaces.
 *  All the words in sentences[i] are separated by a single space.
 *  
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: sentences.length = 1, sentences.length = 100.
 * 4. edge cases: sentences[i].length = 1, sentences[i].length = 100.
 * 5. very long words, very long sentences, very short words
 */

/* Simple solution. 
 * Time complexity: O(m*n) (n is sentences.length, m is sentences[i].length)
 * Space complexity: O(1)
 */
class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 1; // The minimum constraint.
        for (String sentence : sentences) {
            int numOfWords = 1; // Start with 1, as num of words = num of space + 1.
            // Process each sentence.
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    // Increment when there is a space.
                    numOfWords++;
                }
            }

            // Check and update the max.
            if (numOfWords > maxWords) {
                maxWords = numOfWords;
            }
        }
        return maxWords;
    }
}

/* Use split function solution. 
 * Time complexity: O(n)
 * Space complexity: O(m*n)
 */
class Solution2 {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 1;
        for (String sentence : sentences) {
            // Use split to get string array of words in the sentence.
            int numOfWords = sentence.split(" ").length;
            // Use ternary operator to update.
            maxWords = maxWords > numOfWords ? maxWords : numOfWords;
        }

        return maxWords;
    }
}


/* Use replace function solution. 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution3 {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 1;
        for (String sentence : sentences) {
            // Count space in the sentence by first replacing spaces with empty string and 
            // use original length minus the new length.
            int numOfWords = sentence.length() - sentence.replace(" ", "").length();
            numOfWords++; // add one as num of words = num of space + 1.
            // Compare and update the max.
            maxWords = Math.max(maxWords, numOfWords);
        }

        return maxWords;
    }
}

/* StringTokenizer solution. 
 * Time complexity: O(n)
 * Space complexity: O(m*n)
 */
class Solution4 {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 1;
        for (String sentence : sentences) {
            // Break string into tokens and count.
            int numOfWords = new StringTokenizer(sentence, " ").countTokens();
            maxWords = maxWords > numOfWords ? maxWords : numOfWords;
        }

        return maxWords;
    }
}
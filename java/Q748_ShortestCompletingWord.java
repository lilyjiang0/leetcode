package java;

/* Array.
 * Given a string licensePlate and an array of strings words, find the shortest 
 * completing word in words.
 * 
 * A completing word is a word that contains all the letters in licensePlate. Ignore numbers and 
 * spaces in licensePlate, and treat letters as case insensitive. If a letter appears more than 
 * once in licensePlate, then it must appear in the word the same number of times or more.
 * 
 * For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), 
 * and 'c' twice. Possible completing words are "abccdef", "caaacab", and "cbca".
 * 
 * Return the shortest completing word in words. It is guaranteed an answer exists. If there are 
 * multiple shortest completing words, return the first one that occurs in words.
 * 
 * Constraints:
 *  1 <= licensePlate.length <= 7
 *  licensePlate contains digits, letters (uppercase or lowercase), or space ' '.
 *  1 <= words.length <= 1000
 *  1 <= words[i].length <= 15
 *  words[i] consists of lower case English letters.
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases:
 */

/* My solution. Use an int array for characters.
 * Time complexity: O(nlog(n))
 * Space complexity: O(26n) worst case
*/
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] dict = containLetter(licensePlate.toLowerCase());
        String out = "";
        for (String word : words) {
            // Compare only when there is out is empty or word is shorter than the current out.
            if (out == "" || word.length() < out.length()) {
                if (compare(dict, containLetter(word))) {
                    out = word;
                }
            }
        }
        return out;
    }

    public Boolean compare(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            // Compare when the letter exists in array1.
            // Return false if num of letter in array1 is greater than array2.
            if (array1[i] != 0 && array1[i] > array2[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] containLetter(String string) {
        int[] out = new int[26];
        for (char c : string.toCharArray()) {
            // Letter only.
            if (Character.isLetter(c)) {
                out[c - 'a']++;
            }
        }
        return out;
    }
}

/* Prime number product. Potential issue of overflow.
 * https://leetcode.com/problems/shortest-completing-word/solutions/158110/java-6ms-beats-100-prime-numbers/
 * Time complexity: O(nlog(n))
 * Space complexity: O(1)
 */
class Solution2 {
    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103}; 
    
    public String shortestCompletingWord(String licensePlate, String[] words) {
        long charProduct = getCharProduct(licensePlate.toLowerCase());
        String shortest = "aaaaaaaaaaaaaaaaaaaa"; // 16 a's
        for(String word : words)
            if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
                    shortest = word;
        return shortest;
    }
    
    private long getCharProduct(String plate) {
        long product = 1L;
        for(char c : plate.toCharArray()) {
            int index = c - 'a';
            if (0 <= index && index <= 25) 
                product *= primes[index];
        }
        return product;
    }
}
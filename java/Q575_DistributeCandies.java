package java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* Hash table
 * Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she 
 * started to gain weight, so she visited a doctor.
 * 
 * The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice 
 * likes her candies very much, and she wants to eat the maximum number of different types of 
 * candies while still following the doctor's advice.
 * 
 * Given the integer array candyType of length n, return the maximum number of different types 
 * of candies she can eat if she only eats n / 2 of them.
 * 
 * Constraints:
 *  n == candyType.length
 *  2 <= n <= 10^4
 *  n is even.
 *  -10^5 <= candyType[i] <= 10^5
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: candyType.length = 2, candyType.length = 10^4
 * 4. edge cases: candyType[i] = -10^5, candyType[i] = 10^5
 * 5. candyType[i] not in order
 * 6. number of different types > n / 2
 * 7. number of different types < n / 2
 */

/* Hashset solution.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            set.add(candyType[i]);
            // Return if the maximum is reached.
            if (set.size() == candyType.length / 2) {
                return set.size();
            }
        }
        return set.size();
    }
}

/* Sort solution.
 * Time complexity: O(nlog(n))
 * Space complexity: O(1)
 */
class Solution2 {
    public int distributeCandies(int[] candyType) {
        int count = 0;
        Arrays.sort(candyType);
        int prev = 100001;
        for (int i = 0; i < candyType.length; i++) {
            // Check for previous. Count if different.
            if (prev != candyType[i]) {
                count++;
                prev = candyType[i];
            }
            // Return if the maximum is reached.
            if (count == candyType.length / 2) {
                return count;
            }
        }
        return count;
    }
}

/* Array solution.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution3 {
    public int distributeCandies(int[] candyType) {
        // Based on constraint -10^5 <= candyType[i] <= 10^5. Need 100000+100000+1 length to store.
        int[] count = new int[200001];
        int res = 0;
        for (int i = 0; i < candyType.length; i++) {
            // Add 100000 to ensure all positive index are positive.
            int index = candyType[i] + 100000; 
            // Count if never appeared.
            if (count[index] == 0) {
                res++;
                count[index]++;
            }
            // Return if the maximum is reached.
            if (res == candyType.length / 2) {
                return res;
            }
        }
        return res;
    }
}
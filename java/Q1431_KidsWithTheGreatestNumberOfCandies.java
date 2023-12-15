package java;

import java.util.ArrayList;
import java.util.List;

/*
 * There are n kids with candies. You are given an integer array candies, where each candies[i] 
 * represents the number of candies the ith kid has, and an integer extraCandies, denoting the 
 * number of extra candies that you have.
 * 
 * Return a boolean array result of length n, where result[i] is true if, after giving the ith 
 * kid all the extraCandies, they will have the greatest number of candies among all the kids, 
 * or false otherwise.
 * 
 * Note that multiple kids can have the greatest number of candies.
 * 
 * Constraints:
 *  n == candies.length
 *  2 <= n <= 100
 *  1 <= candies[i] <= 100
 *  1 <= extraCandies <= 50
 * 
 * Test cases:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: n = 2, n = 100
 * 4. edge cases: candies[i] = 1, candies[i] = 100
 * 5. edge cases: extraCandies = 1, extraCandies = 50
 * 6. multiple kids have the greatest number of candies.
 * 7. candies[i] are all equal
 */

/* 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution1 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int can : candies) {
            max = Math.max(can, max);
        }
        // Specify arraylist's size explicitly, to not loose time on array copy during grow.
        ArrayList<Boolean> result = new ArrayList<>(candies.length);
        for (int can : candies) {
            result.add(can + extraCandies >= max);
        }
        return result;
    }
}

/* Minor Optimization. Avoid the need to plus n time.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution2 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int can : candies) {
            max = Math.max(can, max);
        }
        int need = max - extraCandies;
        ArrayList<Boolean> result = new ArrayList<>(candies.length);
        for (int can : candies) {
            result.add(can >= need);
        }
        return result;
    }
}
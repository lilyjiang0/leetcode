package java;

import java.util.ArrayList;
import java.util.List;

/* Array.
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * 
 * Constraints:
 *  0 <= rowIndex <= 33
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: rowIndex = 0, rowIndex = 33
 */

/* My solution.
 * Time complexity: O(nlog(n))
 * Space complexity: O(2n-1)
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (rowIndex == 0) {
            return list;
        }
        list.add(1);
        if (rowIndex == 1) {
            return list;
        }

        for (int i = 2; i < rowIndex + 1; i++) {
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(list.get(j) + list.get(j - 1));
            }

            list.add(1);
            list = list.subList(i, list.size());
        }

        return list;
    }
}

/* Similar idea as my solution but use O(n) space.
 * When generating each row, we can use the previous row directly, so this way we only use O(k) 
 * space with k being the number of row. For each new row, we append a 1, letting j iterate from 
 * i - 1 backward to 1, and set the jth element as res.set(j, res.get(j-1) + res.get(j)).
 * https://leetcode.com/problems/pascals-triangle-ii/solutions/38473/java-o-k-solution-with-explanation/
 * 
 * Time complexity: O(nlog(n))
 * Space complexity: O(n)
 */
class Solution2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            res.add(1);
            for(int j = i-1; j > 0; j--) {
                res.set(j, res.get(j-1) + res.get(j));
            }
        }
        return res;
    }
}

/* Math solution.
 * suppose we have nCr and we have to find nC(rowIndex+1), like 5C3 and 5C4
 * ==> 5C3 = 5*4*3 / 1*2*3
 * to get the next term we multiply numerator with its next term and denominator with its next term.
 * ==> 5C4 = 5*4*3 * 2 / 1*2*3 * 4
 * We are following this simple maths logic to get the complete row in O(N) time.
 * https://leetcode.com/problems/pascals-triangle-ii/solutions/1203260/very-easy-o-n-time-0-ms-beats-100-simple-maths-all-languages/
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution3 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        long temp = 1;
        for(int i = 1, up = rowIndex, down = 1; i <= rowIndex; i++, up--, down++){
            temp = temp * up / down;
            ans.add((int)temp);
        }
        return ans;
    }
}

/* Another math solution.
 * The row's first element is always 1. Given the previous element in the row (prev), 
 * the next element can be calculated using:
 * next_val = prev × (rowIndex − k + 1) / k
 * 
 * This formula is derived from the relationship between consecutive binomial coefficients 
 * in the same row.
 * 
 * Iterating from k = 1 to k = rowIndex, we can directly generate the elements for 
 * the desired row without building the entire triangle.
 * 
 * https://leetcode.com/problems/pascals-triangle-ii/solutions/4173164/100-easy-optimized/
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution4 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        long prev = 1;
        for (int k = 1; k <= rowIndex; k++) {
            long next_val = prev * (rowIndex - k + 1) / k;
            res.add((int) next_val);
            prev = next_val;
        }
        return res;
    }
}
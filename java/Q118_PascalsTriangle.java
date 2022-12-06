package java;

import java.util.ArrayList;
import java.util.List;

/* Array
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * Assumption: 1 <= numRows <= 30
 */

 /* 
  * Time complexity: O(n^2)
  * Space complexity: O(n^2)
  *
  * Test:
  * 1. Normal cases e.g. 4,8,10
  * 2. edge cases, 1 & 30
  */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // Rows
        for (int i = 0; i < numRows; i++) {
            // Inside rows
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) { // first and last.
                    list.add(1);
                } else {
                    // Get j - 1 and j element from above row.
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    list.add(a + b);
                }

            }
            result.add(list);
        }
        return result;
    }
}
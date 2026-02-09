package java;

import java.util.ArrayList;
import java.util.List;

/** String
 * A cell (r, c) of an excel sheet is represented as a string "<col><row>" where:
 * <col> denotes the column number c of the cell. It is represented by alphabetical letters.
 * For example, the 1st column is denoted by 'A', the 2nd by 'B', the 3rd by 'C', and so on.
 * <row> is the row number r of the cell. The rth row is represented by the integer r.
 * 
 * You are given a string s in the format "<col1><row1>:<col2><row2>", where <col1> represents 
 * the column c1, <row1> represents the row r1, <col2> represents the column c2, and <row2> 
 * represents the row r2, such that r1 <= r2 and c1 <= c2.
 * 
 * Return the list of cells (x, y) such that r1 <= x <= r2 and c1 <= y <= c2. The cells should
 * be represented as strings in the format mentioned above and be sorted in non-decreasing order 
 * first by columns and then by rows.
 * 
 * Constraints:
 * - s.length == 5
 * - 'A' <= s[0] <= s[3] <= 'Z'
 * - '1' <= s[1] <= s[4] <= '9'
 * - s consists of uppercase English letters, digits and ':'.
 * 
 * Time Complexity: O(C*R)
 * Space Complexity: O(C*R)
 * Let C = c2 - c1 + 1 (number of columns), R = r2 - r1 + 1 (number of rows).
 * 
 * Tests:
 * - s[0] = s[3]
 * - s[0] = 'A', s[3] = 'Z'
 * - s[1] = s[4]
 * - s[1] = '1', s[4] = '9'
 * - s[0] = s[3] and s[1] = s[4] e.g. A1:A1
 * - s[0] = s[3], s[1] = '1', s[4] = '9' e.g. A1:A9
 * - s[0] = 'A', s[3] = 'Z' and s[1] = s[4] e.g. A5:Z5
 */
class Solution {
    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();
        char c1 = s.charAt(0);
        char c2 = s.charAt(3);
        char r1 = s.charAt(1);
        char r2 = s.charAt(4);
        for (char i = c1; i <= c2; i++) {
            for (char j = r1; j <= r2; j++) {
                String cell = i + "" + j;
                res.add(cell);
            }
        }
        return res;
    }
}

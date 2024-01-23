package java;

/* Array.
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a 
 * new one with a different size r x c keeping its original data.
 * 
 * You are given an m x n matrix mat and two integers r and c representing the number of rows and 
 * the number of columns of the wanted reshaped matrix.
 * 
 * The reshaped matrix should be filled with all the elements of the original matrix in the same 
 * row-traversing order as they were.
 * 
 * If the reshape operation with given parameters is possible and legal, output the new reshaped 
 * matrix; Otherwise, output the original matrix.
 * 
 * Constraints:
 *  m == mat.length
 *  n == mat[i].length
 *  1 <= m, n <= 100
 *  -1000 <= mat[i][j] <= 1000
 *  1 <= r, c <= 300
 * 
 * Time complexity: O(r*c)
 * Space complexity: O(r*c)
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: m = 1, n = 100, very large m, n = 1
 * 4. edge cases: mat[i][j] = -1000, mat[i][j] = 1000
 * 5. edge cases: r = 1, c = 300, very large r, c = 1
 * 6. invalid input: given parameters is not possible and legal
 */
/* Simple solution.
 */
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int mr = mat.length;
        int mc = mat[0].length;
        if (mr * mc != r * c) {
            return mat;
        }
        int[][] out = new int[r][c];
        int currCol = 0;
        int currRow = 0;
        for (int i  = 0; i < mr; i++) {
            for (int j = 0; j < mc; j++) {
                out[currRow][currCol] = mat[i][j];
                currCol++;
                if (currCol == c) {
                    currCol = 0;
                    currRow++;
                } 
            }
        }
        return out;
    }
}

/* Double loop solution.
* To fill in the reshaped 'ret' matrix, this algorithm has two loops. The outer loop
* iterates over the rows of mat; the inner loop iterates over the cols of mat.
*
* Example:
*
*                                        row 0   1
*                                      col ---------
*         row 0   1   2                 0  | a | b |
*       col  ------------                  |-------|
*        0  | a | b | c |               1  | c | d |
*           |-----------|   ------->       |-------|
*        1  | d | e | f |               2  | e | f |
*            -----------                   |-------|
*
*           mat matrix                    ret matrix
*         mr = 1, mc = 3                  r = 3, c = 2
*
*
*        -------- mat --------------    ------- ret ----------------
*  i j k     mat[i][j]                  ret[k/c][k%c]
*  - - - ---------------------------    ----------------------------
*  0 0 0     mat[0,0] = a           --> ret[0/2][0/2] = ret[0][0]
*  0 1 1     mat[0,1] = b           --> ret[1/2][1/2] = ret[0][1]
*  0 2 2     mat[0,2] = c           --> ret[2/2][2/2] = ret[1][0]
*  1 0 3     mat[1,0] = d           --> ret[3/2][3/2] = ret[1][1]
*  1 1 4     mat[1,1] = e           --> ret[4/2][4/2] = ret[2][0]
*  1 2 5     mat[1,2] = f           --> ret[5/2][5/2] = ret[2][1]
*
* The total number of division operations of the two loops is n * 2,
* where n = mr * mc. This is half as many division operations as the
* single-loop version below.
*/
class Solution2 {
	public int[][] matrixReshape(final int[][] mat, final int r, final int c) {
         final int mr = mat.length;
         final int mc =  mat[0].length;
         final int n =  mr * mc;

        // check arguments
        if (r * c != n) {
            return mat;
        }

         // create reshaped matrix
         final int[][] ret = new int[r][c];
         int k = 0; // number of cells filled in so far
         for (int i = 0; i < mr; i++) {
             for (int j = 0; j < mc; j++) {
                 ret[k / c][k % c] = mat[i][j]; // see explanation above
                 k++;
             }
         }
         return ret;
    }
}

/* Single loop solution.
* To fill in the reshaped 'ret' matrix, this algorithm iterates over n elements
* where n is the rows multiplied by the columns.
*
* Example:
*
*                                        row 0   1
*                                      col ---------
*         row 0   1   2                 0  | a | b |
*       col  ------------                  |-------|
*        0  | a | b | c |               1  | c | d |
*           |-----------|   ------->       |-------|
*        1  | d | e | f |               2  | e | f |
*            -----------                   |-------|
*
*           mat matrix                    ret matrix
*         mr = 1, mc = 3                  r = 3, c = 2
*
*
*    ----------- mat ------------     ----------- mat ------------
*  i      mat[i/mc][i%mc]             ret[i/c][i%c]
*  - ----------------------------     ----------------------------
*  0 mat[0/3][0%3] = mat[0,0] = a --> ret[0/2][0/2] = ret[0][0]
*  1 mat[1/3][1%3] = mat[0,1] = b --> ret[1/2][1/2] = ret[0][1]
*  2 mat[2/3][2%3] = mat[0,2] = c --> ret[2/2][2/2] = ret[1][0]
*  3 mat[3/3][3%3] = mat[1,0] = d --> ret[3/2][3/2] = ret[1][1]
*  4 mat[4/3][4%3] = mat[1,1] = e --> ret[4/2][4/2] = ret[2][0]
*  5 mat[5/3][5%3] = mat[1,2] = f --> ret[5/2][5/2] = ret[2][1]
*
* The total number of division operations of the single loop is n * 4,
* where n = mr * mc. This is twice as many division operations as the
* double-loop version above.
*
* Time complexity: O(r*c)
* Space complexity: O(r*c)
*/
class Solution3 {
    public int[][] matrixReshape(final int[][] mat, final int r, final int c) {
        final int mr = mat.length;
        final int mc =  mat[0].length;
        final int n =  mr * mc;

        // check arguments
        if (r * c != n) {
            return mat;
        }

        // create reshaped matrix
        final int[][] ret = new int[r][c];
        for (int i = 0; i < n; i++) {
            ret[i / c][i % c] = mat[i / mc][i % mc];
        }
        return ret;
    }
}


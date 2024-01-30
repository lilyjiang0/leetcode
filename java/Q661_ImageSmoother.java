package java;

/* Array.
 * An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image 
 * by rounding down the average of the cell and the eight surrounding cells (i.e., the average 
 * of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell 
 * is not present, we do not consider it in the average (i.e., the average of the four cells in 
 * the red smoother).
 * 
 * Given an m x n integer matrix img representing the grayscale of an image, return the image 
 * after applying the smoother on each cell of it.
 * 
 * Constraints:
 *  m == img.length
 *  n == img[i].length
 *  1 <= m, n <= 200
 *  0 <= img[i][j] <= 255
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: img.length = 1, img.length = 200
 * 4. edge cases: img[i].length = 1, img[i].length = 200
 * 5. edge cases: img[i][j] = 0, img[i][j] = 255
 */

/* https://leetcode.com/problems/image-smoother/solutions/106593/c-o-1-space-using-game-of-life-idea/
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] out = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Loop through the matrix and smooth each cell.
                out[i][j] = smooth(img, i, j);
            }
        }
        return out;
    }

    public int smooth(int[][] img, int x, int y) {
        int sum = 0;
        int count = 0;
        // Check each surrounding cell from the top left to the top right corner.
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                // Skip conditions when surrounding cells of a cell is not present.
                if (nx < 0 || ny < 0 || nx >= img.length || ny >= img[0].length) {
                    continue;
                }
                sum += img[nx][ny];
                count++;
            }
        }
        return sum / count;
    }
}

/* Better runtime. Reduce the amount of rows and columns to loop through during the smooth process.
 * https://leetcode.com/problems/image-smoother/solutions/4423391/video-give-me-10-minutes-how-we-think-about-a-solution/
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
class Solution2 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] out = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                out[i][j] = smooth(img, i, j);
            }
        }
        return out;
    }

    public int smooth(int[][] img, int x, int y) {
        int sum = 0;
        int count = 0;
        // Calculate the row and column boundary that exist a surrounding cell.
        int top = Math.max(0, x - 1);
        int bottom = Math.min(img.length - 1, x + 1);
        int left = Math.max(0, y - 1);
        int right = Math.min(img[0].length - 1, y + 1);
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                sum += img[i][j];
                count++;
            }
        }
        return sum / count;
    }
}

/* In-place solution. Works because of the limitation img[i][j] <= 255. Use bit shifting to store 
 * both smoothed and old value in the same position.
 * https://www.youtube.com/watch?v=xa83GG1RIOY&ab_channel=NeetCodeIO
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
class Solution3 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Shift the new value to the left by 8 bits and xor the old value.
                // The old value will stay in the last 8 bits.
                img[i][j] = img[i][j] ^ smooth(img, i, j) << 8;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Shift the smoothed value to the right by 8 bits to eliminate the old value.
                img[i][j] = img[i][j] >> 8;
            }
        }
        return img;
    }

    public int smooth(int[][] img, int x, int y) {
        int sum = 0;
        int count = 0;

        int top = Math.max(0, x - 1);
        int bottom = Math.min(img.length - 1, x + 1);
        int left = Math.max(0, y - 1);
        int right = Math.min(img[0].length - 1, y + 1);
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                // Get the old value.
                sum += img[i][j] % 256;
                count++;
            }
        }
        return sum / count;
    }
}
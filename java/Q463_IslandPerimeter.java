package java;

/* Hash Table.
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and 
 * grid[i][j] = 0 represents water.
 * 
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely 
 * surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * 
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around 
 * the island. One cell is a square with side length 1. The grid is rectangular, width and 
 * height don't exceed 100. Determine the perimeter of the island.
 * 
 * Constraints:
 *  row == grid.length
 *  col == grid[i].length
 *  1 <= row, col <= 100
 *  grid[i][j] is 0 or 1.
 *  There is exactly one island in grid.
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: grid.length, grid[i].length = 1, grid.length, grid[i].length = 100
 * 4. all grid[i][j] = 1
 * 5. there is only one grid[i][j] = 1
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */

/* My solution. For each cell, check the num of island next to it and count the perimeter.
 */
class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count += getCellPerimeter(grid, i, j);
                }
            }
        }
        return count;
    }

    public int getCellPerimeter(int[][] grid, int i, int j) {
        int cellPerimeter = 4;
        // Check the four cells horizontally/vertically next to the current cell.
        // If any is an island, we deduct 1 from the perimeter. 
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            cellPerimeter--;
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            cellPerimeter--;
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            cellPerimeter--;
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            cellPerimeter--;
        }


        return cellPerimeter;
    }
}

/* Math solution.
 * https://leetcode.com/problems/island-perimeter/solutions/95001/clear-and-easy-java-solution/
 */
class Solution2 {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    // count down neighbours
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++;
                    // count right neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++;
                }
            }
        }
        return islands * 4 - neighbours * 2;
    }
}

/* DFS solution.
 * https://leetcode.com/problems/island-perimeter/solutions/95004/java-solution-with-dfs/
 */
class Solution3 {
    public int islandPerimeter(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
               if (grid[row][col] == 1) {
                    return getPerimeterDFS(grid, row, col);
               }
            }
        }
        
        return 0;
    }
    
    // helper method to calculate perimeter recursively 
    private int getPerimeterDFS(int[][] grid, int row, int col) {
        // Check boundary conditions and return 1
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 1;
        }
        // Check if the cell is water and return 1. No need to do a DFS
        if (grid[row][col] == 0) {
            return 1;
        }
        
        // check if the cell is already visisted and return 0
        if (grid[row][col] == -1) {
            return 0;
        }
        
        // mark current cell as visited
        grid[row][col] = -1;
        
        // calculate perimeter in all four directions, do not add one here since we are return 1 
        // from the base case if it is water.
        int count = getPerimeterDFS(grid, row + 1, col)
                  + getPerimeterDFS(grid, row - 1, col)
                  + getPerimeterDFS(grid, row, col - 1)
                  + getPerimeterDFS(grid, row, col + 1);
        
        //return the perimeter
        return count;
    }
} 
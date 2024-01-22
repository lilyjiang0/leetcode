package java;


class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int numOfElements = mat.length * mat[0].length;
        if (numOfElements != r * c) {
            return mat;
        }
        int[][] out = new int[r][c];
        int[] row = new int[c];
        int k = 0;
        int g = 0;
        for (int i  = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                row[k] = mat[i][j];
                k++;
                if (k == c) {
                    k = 0;
                    out[g] = row;
                    g++;
                    row = new int[c];
                } 
                // System.out.println(k);
            }
        }
        return out;
    }
}
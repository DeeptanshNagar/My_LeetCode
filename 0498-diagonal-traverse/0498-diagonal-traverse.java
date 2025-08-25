class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int i = 0, j = 0, k = 0;
        boolean up = true;

        while (k < m * n) {
            ans[k++] = mat[i][j];

            if (up) {
                if (j == n - 1) { 
                    i++; 
                    up = false; 
                }
                else if (i == 0) { 
                    j++; 
                    up = false; 
                }
                else { 
                    i--; 
                    j++; 
                }
            } 
            else {
                if (i == m - 1) { 
                    j++; 
                    up = true; 
                }
                else if (j == 0) { 
                    i++; 
                    up = true; 
                }
                else { 
                    i++; 
                    j--; 
                }
            }
        }
        return ans;
    }
}

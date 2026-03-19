class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int prefX[][] = new int[m][n];
        int prefY[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefX[i][j] = (grid[i][j] == 'X') ? 1 : 0;
                prefY[i][j] = (grid[i][j] == 'Y') ? 1 : 0;
                if (i > 0) {
                    prefX[i][j] += prefX[i - 1][j];
                    prefY[i][j] += prefY[i - 1][j];
                }
                if (j > 0) {
                    prefX[i][j] += prefX[i][j - 1];
                    prefY[i][j] += prefY[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    prefX[i][j] -= prefX[i - 1][j - 1];
                    prefY[i][j] -= prefY[i - 1][j - 1];
                }
                if (prefX[i][j] == prefY[i][j] && prefX[i][j] > 0) ans++;
            }
        }
        return ans;
    }
}
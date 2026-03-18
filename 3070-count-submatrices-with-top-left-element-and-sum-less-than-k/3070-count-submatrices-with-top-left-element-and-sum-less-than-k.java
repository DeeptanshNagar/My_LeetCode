class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] > k) return 0;
        int count = 1, temp = n;
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
            if (grid[0][i] > k) {
                temp = i;
                break;
            }
            count++;
        }
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
            if (grid[i][0] > k) break;
            count++;
            for (int j = 1; j < temp; j++) {
                grid[i][j] += grid[i - 1][j] + grid[i][j - 1] - grid[i - 1][j - 1];
                if (grid[i][j] > k) {
                    temp = j;
                    break;
                }
                count++;
            }
        }
        return count;
    }
}
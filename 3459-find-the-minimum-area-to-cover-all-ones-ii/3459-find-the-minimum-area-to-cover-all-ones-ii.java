class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = m * n;
        for (int i = 0; i < m; i++) {
            int top = minimumArea(grid, 0, i, 0, n - 1);
            for (int j = 0; j < n; j++) {
                ans = Math.min(ans, top +
                              minimumArea(grid, i + 1, m - 1, 0, j) +
                              minimumArea(grid, i + 1, m - 1, j + 1, n - 1));
            }
        }
        
        for (int i = 0; i < m; i++) {
            int bottom = minimumArea(grid, i, m - 1, 0, n - 1);
            for (int j = 0; j < n; j++) {
                ans = Math.min(ans, bottom +
                              minimumArea(grid, 0, i - 1, 0, j) +
                              minimumArea(grid, 0, i - 1, j + 1, n - 1));
            }
        }
        
        for (int j = 0; j < n; j++) {
            int left = minimumArea(grid, 0, m - 1, 0, j);
            for (int i = 0; i < m; i++) {
                ans = Math.min(ans, left +
                              minimumArea(grid, 0, i, j + 1, n - 1) +
                              minimumArea(grid, i + 1, m - 1, j + 1, n - 1));
            }
        }
        
        for (int j = 0; j < n; j++) {
            int right = minimumArea(grid, 0, m - 1, j, n - 1);
            for (int i = 0; i < m; i++) {
                ans = Math.min(ans, right +
                              minimumArea(grid, 0, i, 0, j - 1) +
                              minimumArea(grid, i + 1, m - 1, 0, j - 1));
            }
        }
        
        for (int i1 = 0; i1 < m; i1++) {
            for (int i2 = i1 + 1; i2 < m; i2++) {
                ans = Math.min(ans, minimumArea(grid, 0, i1, 0, n - 1) +
                                   minimumArea(grid, i1 + 1, i2, 0, n - 1) +
                                   minimumArea(grid, i2 + 1, m - 1, 0, n - 1));
            }
        }
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = j1 + 1; j2 < n; j2++) {
                ans = Math.min(ans, minimumArea(grid, 0, m - 1, 0, j1) +
                                   minimumArea(grid, 0, m - 1, j1 + 1, j2) +
                                   minimumArea(grid, 0, m - 1, j2 + 1, n - 1));
            }
        }
        return ans;
    }
    
    private int minimumArea(int[][] grid, int si, int ei, int sj, int ej) {
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = 0;
        int y2 = 0;
        for (int i = si; i <= ei; i++) {
            for (int j = sj; j <= ej; j++) {
                if (grid[i][j] == 1) {
                    x1 = Math.min(x1, i);
                    y1 = Math.min(y1, j);
                    x2 = Math.max(x2, i);
                    y2 = Math.max(y2, j);
                }
            }
        }
        return x1 == Integer.MAX_VALUE ? 0 : (x2 - x1 + 1) * (y2 - y1 + 1);
    }
}
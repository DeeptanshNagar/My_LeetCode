class Solution {
    public int largestSubmatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1 && r > 0) {
                    grid[r][c] = grid[r][c] + grid[r - 1][c];
                }
            }

            int heights[] = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = grid[r][i];
            }

            Arrays.sort(heights);
            for (int i = n - 1; i >= 0; i--) {
                int width = n - i;
                int area = heights[i] * width;
                if (area > ans) ans = area;
            }
        }
        return ans;
    }
}
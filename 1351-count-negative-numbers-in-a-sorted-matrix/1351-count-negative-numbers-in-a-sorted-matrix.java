class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            if (grid[i][0] > 0 && grid[i][grid[0].length - 1] > 0) return ans;
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] < 0) ans++;
            }
        }
        return ans;
    }
}
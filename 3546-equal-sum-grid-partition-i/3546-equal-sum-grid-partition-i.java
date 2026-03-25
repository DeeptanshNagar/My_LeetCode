class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long total = 0;

        long row[] = new long[m];
        long col[] = new long[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        }

        if (total % 2 != 0) return false;
        long target = total / 2;

        long sum = 0;
        for (int i = 0; i < m - 1; i++) {
            sum += row[i];
            if (sum == target) return true;
        }

        sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += col[i];
            if (sum == target) return true;
        }
        return false;
    }
}
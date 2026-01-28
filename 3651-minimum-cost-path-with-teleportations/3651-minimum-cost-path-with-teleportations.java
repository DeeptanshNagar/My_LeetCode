class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }

        int dp[][] = new int[m][n];
        
        int minCost[] = new int[max + 1];
        int best[] = new int[max + 1];
        
        Arrays.fill(minCost, Integer.MAX_VALUE);
        
        minCost[grid[m - 1][n - 1]] = 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;
                
                int down = (i + 1 < m) ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE;
                int right = (j + 1 < n) ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE;
                
                dp[i][j] = Math.min(down, right);
                
                if (dp[i][j] != Integer.MAX_VALUE) minCost[grid[i][j]] = Math.min(minCost[grid[i][j]], dp[i][j]);
            }
        }

        for (int x = 0; x < k; x++) {
            best[0] = minCost[0];
            for (int i = 1; i <= max; i++) {
                best[i] = Math.min(best[i - 1], minCost[i]);
            }
            
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == m - 1 && j == n - 1) continue;
                    
                    int down = (i + 1 < m) ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE;
                    int right = (j + 1 < n) ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE;

                    int walkCost = Math.min(down, right);
                    int teleportCost = best[grid[i][j]];
                    dp[i][j] = Math.min(walkCost, teleportCost);
                    
                    if (dp[i][j] != Integer.MAX_VALUE) minCost[grid[i][j]] = Math.min(minCost[grid[i][j]], dp[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
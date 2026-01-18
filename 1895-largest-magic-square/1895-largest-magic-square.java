class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int min = Math.min(n, m); 

        for (int k = min; k > 1; k--) { 
            for (int i = 0; i <= n - k; i++) { 
                for (int j = 0; j <= m - k; j++) {
                    boolean isMagic = true;
                    int first_row = 0;
                    for (int l = 0; l < k; l++) {
                        first_row += grid[i][j + l];
                    }

                    for (int r = 0; r < k; r++) {
                        int sum_row = 0;
                        for (int c = 0; c < k; c++) {
                            sum_row += grid[i + r][j + c];
                        }
                        if (sum_row != first_row) {
                            isMagic = false;
                            break;
                        }
                    }
                    
                    for (int c = 0; c < k && isMagic; c++) {
                        int sum_col = 0;
                        for (int r = 0; r < k; r++) {
                            sum_col += grid[i + r][j + c];
                        }
                        if (sum_col != first_row) {
                            isMagic = false;
                            break;
                        }
                    }

                    int left_diag = 0;
                    for (int l = 0; l < k && isMagic; l++) {
                        left_diag += grid[i + l][j + l];
                    }
                    if (left_diag != first_row) isMagic = false;

                    int right_diag = 0;
                    for (int l = 0; l < k && isMagic; l++) {
                        right_diag += grid[i + l][j + k - 1 - l];
                    }
                    if (right_diag != first_row) isMagic = false;

                    if (isMagic) return k;
                }
            }
        }
        return 1;
    }
}
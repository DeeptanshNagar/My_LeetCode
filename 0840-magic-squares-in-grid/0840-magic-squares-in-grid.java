class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int ans = 0;
        for (int i = 0; i + 2 < row; i++) {
            for (int j = 0; j + 2 < col; j++) {
                if (isMagic(grid, i, j)) ans++; 
            }
        }
        return ans;
    }
    boolean isMagic(int[][] grid, int i, int j) {
        int vals[] = new int[10];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int num = grid[i + x][j + y];
                if (num < 1 || num > 9 || vals[num]++ > 0) return false;
            }
        }
        
        int dia_1 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        int dia_2 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];
        int row_1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
        int row_2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
        int row_3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
        int col_1 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
        int col_2 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
        int col_3 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];

        return (dia_1 == dia_2) && (dia_1 == row_1) && (dia_1 == row_2) && (dia_1 == row_3) && (dia_1 == col_1) && (dia_1 == col_2) && (dia_1 == col_3);
    }
}
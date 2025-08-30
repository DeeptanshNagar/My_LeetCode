class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowHasNumber = new boolean[9][9];
        boolean[][] columnHasNumber = new boolean[9][9];
        boolean[][] subBoxHasNumber = new boolean[9][9];
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char currentCell = board[row][column];
                if (currentCell == '.') {
                    continue;
                }
                int digitIndex = currentCell - '0' - 1;
                int subBoxIndex = (row / 3) * 3 + (column / 3);
                if (rowHasNumber[row][digitIndex] || 
                    columnHasNumber[column][digitIndex] || 
                    subBoxHasNumber[subBoxIndex][digitIndex]) {
                    return false;
                }
                rowHasNumber[row][digitIndex] = true;
                columnHasNumber[column][digitIndex] = true;
                subBoxHasNumber[subBoxIndex][digitIndex] = true;
            }
        }
        return true;
    }
}
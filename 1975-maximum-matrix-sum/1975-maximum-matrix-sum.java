class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0, min = Long.MAX_VALUE;
        int n = matrix.length, count = 0;
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] < 0) count++;
                min = Math.min(Math.abs(matrix[row][col]), min);
                sum += Math.abs(matrix[row][col]);
            }
        }
        
        if (count % 2 == 1) sum -= (2 * min);
        return sum;
    }
}
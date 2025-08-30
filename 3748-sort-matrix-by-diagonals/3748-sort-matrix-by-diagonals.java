class Solution {
    public int[][] sortMatrix(int[][] matrix) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.putIfAbsent(key, key < 0 ? new PriorityQueue<>() 
                                                     : new PriorityQueue<>(Collections.reverseOrder()));
                map.get(key).offer(matrix[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                matrix[i][j] = map.get(key).poll();
            }
        }

        return matrix;
    }
}
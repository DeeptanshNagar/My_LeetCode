class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int graph[][] = new int[m][n];
        
        for (int[] edge : guards) graph[edge[0]][edge[1]] = 2;
        for (int[] edge : walls) graph[edge[0]][edge[1]] = 2;
        
        int directions[] = {-1, 0, 1, 0, -1};
        
        for (int edge[] : guards) {
            for (int k = 0; k < 4; ++k) {
                int x = edge[0], y = edge[1];
                int x_direction = directions[k], y_direction = directions[k + 1];
                
                while (x + x_direction >= 0 && x + x_direction < m && y + y_direction >= 0 && y + y_direction < n && graph[x + x_direction][y + y_direction] < 2) {
                    x += x_direction;
                    y += y_direction;
                    graph[x][y] = 1;
                }
            }
        }
        
        int unguarded = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) unguarded++;
            }
        }
        
        return unguarded;
    }
}
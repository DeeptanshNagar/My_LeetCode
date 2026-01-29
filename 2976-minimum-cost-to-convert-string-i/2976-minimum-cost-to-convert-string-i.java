class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = original.length;
        int grid[][] = new int[26][26];
        for (int i = 0; i < 26; i++) Arrays.fill(grid[i], Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            grid[original[i] - 'a'][changed[i] - 'a'] = Math.min(cost[i], grid[original[i] - 'a'][changed[i] - 'a']);
        }
        for (int i = 0; i < 26; i++) grid [i][i] = 0;
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (grid[i][k] != Integer.MAX_VALUE && grid[k][j] != Integer.MAX_VALUE) {
                        grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                    }
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                int temp = grid[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
                if (temp == Integer.MAX_VALUE) return -1;
                ans += temp;
            }
        }

        return ans;
    }
}
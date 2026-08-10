class Solution {
    int[] memo;
    public boolean winnerSquareGame(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n) == 1;
    }

    private int dfs(int i) {
        if (i == 0) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        for (int j = 1; j * j <= i; j++) {
            if (dfs(i - j * j) == 0) {
                return memo[i] = 1;
            }
        }
        return memo[i] = 0;
    }
}
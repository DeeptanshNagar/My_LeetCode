class Solution {
    public double soupServings(int N) {
        if (N >= 4800) return 1.0;
        int n = (N + 24) / 25;
        Double[][] memo = new Double[n + 1][n + 1];
        return dfs(n, n, memo);
    }

    private double dfs(int a, int b, Double[][] memo) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        if (memo[a][b] != null) return memo[a][b];
        memo[a][b] = 0.25 * (
            dfs(a - 4, b, memo) +
            dfs(a - 3, b - 1, memo) +
            dfs(a - 2, b - 2, memo) +
            dfs(a - 1, b - 3, memo)
        );
        return memo[a][b];
    }
}

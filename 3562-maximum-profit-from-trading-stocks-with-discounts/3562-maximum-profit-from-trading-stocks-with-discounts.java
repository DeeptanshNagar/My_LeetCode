class Solution {
    int n, budget;
    int[] present, future;
    List<Integer>[] tree;

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.n = n;
        this.present = present;
        this.future = future;
        this.budget = budget;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        for (int[] h : hierarchy) {
            int u = h[0] - 1, v = h[1] - 1;
            tree[u].add(v);
        }
        int[][][] dp = dfs(0);
        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[0][0][b]);
        }
        return ans;
    }
    int[][][] dfs(int u) {
        int[][] dp0 = new int[1][budget + 1];
        int[][] dp1 = new int[1][budget + 1];

        for (int v : tree[u]) {
            int[][][] child = dfs(v);
            dp0 = merge(dp0, child[0]);
            dp1 = merge(dp1, child[1]);
        }
        int[][] res0 = new int[1][budget + 1];
        int[][] res1 = new int[1][budget + 1];
        for (int b = 0; b <= budget; b++) {
            res0[0][b] = dp0[0][b];
            int cost = present[u];
            if (b >= cost) {
                res0[0][b] = Math.max(
                    res0[0][b],
                    dp1[0][b - cost] + (future[u] - cost)
                );
            }
        }
        for (int b = 0; b <= budget; b++) {
            res1[0][b] = dp0[0][b];
            int cost = present[u] / 2;
            if (b >= cost) {
                res1[0][b] = Math.max(
                    res1[0][b],
                    dp1[0][b - cost] + (future[u] - cost)
                );
            }
        }
        return new int[][][] { res0, res1 };
    }
    int[][] merge(int[][] a, int[][] b) {
        int[][] res = new int[1][budget + 1];
        for (int i = 0; i <= budget; i++) {
            for (int j = 0; j + i <= budget; j++) {
                res[0][i + j] = Math.max(
                    res[0][i + j],
                    a[0][i] + b[0][j]
                );
            }
        }
        return res;
    }
}
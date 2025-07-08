class Solution {
    public int maxValue(int[][] e, int k) {
        Arrays.sort(e, (a, b) -> a[0] - b[0]);
        int n = e.length;
        int[][] dp = new int[n + 1][k + 1];
        int[] start = new int[n];
        for (int i = 0; i < n; i++)
            start[i] = e[i][0];
        for (int i = n - 1; i >= 0; i--) {
            int next = upperBound(start, e[i][1]);
            for (int j = 1; j <= k; j++)
                dp[i][j] = Math.max(dp[i + 1][j], e[i][2] + dp[next][j - 1]);
        }
        return dp[0][k];
    }
    int upperBound(int[] a, int x) {
        int l = 0, h = a.length;
        while (l < h) {
            int m = (l + h) / 2;
            if (a[m] <= x)
                l = m + 1;
            else
                h = m;
        }
        return l;
    }
}

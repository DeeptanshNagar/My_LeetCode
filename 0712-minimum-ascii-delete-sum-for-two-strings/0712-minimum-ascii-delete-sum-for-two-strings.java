class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        dp[0][0] = 0;

        for (int i = 0; i < m; i++) dp[0][i + 1] = dp[0][i] + s2.charAt(i);
        for (int i = 0; i < n; i++) dp[i + 1][0] = dp[i][0] + s1.charAt(i);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s1.charAt(i) == s2.charAt(j)) dp[i + 1][j + 1] = dp[i][j];
                else dp[i + 1][j + 1] = Math.min(dp[i][j + 1] + s1.charAt(i), dp[i + 1][j] + s2.charAt(j));
            }
        }
        return dp[n][m];
    }
}
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int neg = Integer.MIN_VALUE / 4;
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = neg;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int curr = nums1[i] * nums2[j];
                if (dp[i + 1][j + 1] > 0) curr += dp[i + 1][j + 1];
                dp[i][j] = Math.max(curr, Math.max(dp[i + 1][j], dp[i][j + 1]));
            }
        }

        return dp[0][0];
    }
}
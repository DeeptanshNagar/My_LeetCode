class Solution {
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K - 1 + W) return 1.0;
        double[] dp = new double[N + 1];
        dp[0] = 1.0; 
        double windowSum = 1.0;
        double ans = 0.0;
        for (int i = 1; i <= N; i++) {
            dp[i] = windowSum / W;
            if (i < K) {
                windowSum += dp[i];
            } else {
                ans += dp[i]; 
            }
            if (i - W >= 0) {
                windowSum -= dp[i - W];
            }
        }
        return ans;
    }
}

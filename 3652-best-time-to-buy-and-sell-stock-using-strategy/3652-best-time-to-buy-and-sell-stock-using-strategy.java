class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        int temp = k / 2;
        long sums[] = new long[n + 1];
        long modify = 0, curr = 0;
        for (int i = 0; i < n; i++) {
            sums[i + 1] = curr += strategy[i] * prices[i];
            modify += ((i >= temp & i < k) ? prices[i] : 0);
        }

        long ans = Math.max(sums[n], modify + sums[n] - sums[k]);
        for (int i = 1; i + k <= n; i++) {
            modify += prices[i + k - 1] - prices[i + temp - 1];
            ans = Math.max(ans, modify + sums[n] - sums[i + k] + sums[i]);
        }
        return ans;
    }
}
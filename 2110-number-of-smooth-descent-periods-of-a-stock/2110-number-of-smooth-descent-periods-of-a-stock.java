class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long ans = 1, count = 1;
        for (int i = 1; i < n; i++) {
            if (prices[i - 1] - prices[i] == 1) count++;
            else count = 1;
            ans += count;
        }
        return ans;
    }
}
class Solution {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        long dp0 = 0l;
        long dp1 = nums[0];
        long inf = Long.MIN_VALUE / 4;
        for (int i = 1; i < n; i++) {
            long ndp0 = Math.max(dp0, dp1);
            long best = dp0;
            if (colors[i] != colors[i - 1]) best = Math.max(best, dp1);
            long ndp1 = (best <= inf / 2) ? inf : best + nums[i];
            dp0 = ndp0;
            dp1 = ndp1;
        }
        return Math.max(dp0, dp1);
    }
}
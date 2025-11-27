class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long n = nums.length, INF = Long.MAX_VALUE / 2;
        long prefix[] = new long[k];
        for (int i = 0; i < k - 1; i++) prefix[i] = INF;
        prefix[k - 1] = 0;
        long temp = 0, ans = -INF;
        for(int i = 0; i < n; i++){
            temp += nums[i];
            int ik = i % k;
            ans = Math.max(ans, temp - prefix[ik]);
            prefix[ik] = Math.min(temp, prefix[ik]);  
        }
        return ans;
    }
}
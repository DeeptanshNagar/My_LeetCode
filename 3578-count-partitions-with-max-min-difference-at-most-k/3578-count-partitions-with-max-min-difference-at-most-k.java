class Solution {
    private static final int MOD = 1_000_000_007;
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        dp[0] = 1;
        prefix[0] = 1;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int left = 0;
        for (int right = 0; right < n; right++) {
            int val = nums[right];
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= val) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= val) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() &&
                    (long) nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++;
            }
            int i = right + 1;
            if (left <= right) {
                long totalUpToRight = prefix[i - 1];
                long totalBeforeLeft = (left - 1 >= 0) ? prefix[left - 1] : 0;
                long ways = (totalUpToRight - totalBeforeLeft) % MOD;
                if (ways < 0) ways += MOD;
                dp[i] = ways;
            } else {
                dp[i] = 0;
            }
            prefix[i] = (prefix[i - 1] + dp[i]) % MOD;
        }
        return (int) dp[n];
    }
}
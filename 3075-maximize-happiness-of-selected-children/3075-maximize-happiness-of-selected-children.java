class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        int j = 0;
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k == 0 || happiness[i] - j <= 0) return ans;
            ans += happiness[i] - j;
            j++;
            k--;
        }
        return ans;
    }
}
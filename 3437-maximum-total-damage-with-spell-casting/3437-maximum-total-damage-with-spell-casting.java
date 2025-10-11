class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> damageMap = new HashMap<>();
        for (int p : power) {
            damageMap.put(p, damageMap.getOrDefault(p, 0L) + p);
        }
        List<Integer> keys = new ArrayList<>(damageMap.keySet());
        Collections.sort(keys);
        long[] dp = new long[keys.size()];
        dp[0] = damageMap.get(keys.get(0));

        for (int i = 1; i < keys.size(); i++) {
            int curr = keys.get(i);
            long currDamage = damageMap.get(curr);
            int j = i - 1;
            while (j >= 0 && curr - keys.get(j) <= 2) {
                j--;
            }
            long take = currDamage + (j >= 0 ? dp[j] : 0);
            long skip = dp[i - 1];

            dp[i] = Math.max(take, skip);
        }
        return dp[keys.size() - 1];
    }
}

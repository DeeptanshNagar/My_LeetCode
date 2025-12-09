class Solution {
    public int specialTriplets(int[] nums) {
        int mod = 1000000007;
        int n = nums.length;
        if (n < 3) return 0;
        Map<Integer, Long> left = new HashMap<>();
        Map<Integer, Long> right = new HashMap<>();

        for (int num : nums) right.put(num, right.getOrDefault(num, 0L) + 1);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int mid = nums[i];

            long count = right.get(mid) - 1;
            if (count == 0) right.remove(mid);
            else right.put(mid, count);

            long prev = left.getOrDefault(2 * mid, 0L);
            long next = right.getOrDefault(2 * mid, 0L);

            if (prev > 0 && next > 0) ans = (ans + (prev * next) % mod) % mod;
            left.put(mid, left.getOrDefault(mid, 0L) + 1);
        }
        return (int) ans;
    }
}
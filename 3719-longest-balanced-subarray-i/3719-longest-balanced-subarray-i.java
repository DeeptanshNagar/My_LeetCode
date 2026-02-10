class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            Set<Integer> odd = new HashSet<>();
            Set<Integer> even = new HashSet<>();
            for (int j = i; j < n; j++) {
                if ((nums[j] & 1) == 0) even.add(nums[j]);
                else odd.add(nums[j]);
                if (even.size() == odd.size()) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
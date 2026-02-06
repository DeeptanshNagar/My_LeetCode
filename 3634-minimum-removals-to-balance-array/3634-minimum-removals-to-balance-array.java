class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        int left = 0, right = 0;
        while (right < n) {
            while ((long)k * nums[left] < nums[right]) left++;
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return n - ans;
    }
}
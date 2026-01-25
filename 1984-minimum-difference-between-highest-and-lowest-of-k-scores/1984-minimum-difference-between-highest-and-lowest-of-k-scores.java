class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + k <= nums.length; i++) {
            min = Math.min(min, Math.abs(nums[i] - nums[i + k - 1]));
        }
        return min;
    }
}
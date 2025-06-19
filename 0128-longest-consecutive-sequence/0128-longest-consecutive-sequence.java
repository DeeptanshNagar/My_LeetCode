class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int prevSmallest = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;
        for (int i = 0; i < n; i++) {
            if(nums[i] - 1 == prevSmallest) {
                cnt++;
                prevSmallest = nums[i];
            } else if (nums[i] != prevSmallest) {
                cnt = 1;
                prevSmallest = nums[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
}
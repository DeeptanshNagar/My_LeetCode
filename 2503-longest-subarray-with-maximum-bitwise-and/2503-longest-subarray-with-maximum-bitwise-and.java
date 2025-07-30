class Solution {
    public int longestSubarray(int[] nums) {
        int maxValue = 0;
        int longest = 0;
        int current = 0;

        for (int num : nums) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        for (int num : nums) {
            if (num == maxValue) {
                current++;
                longest = Math.max(longest, current);
            } else {
                current = 0;
            }
        }
        return longest;
    }
}

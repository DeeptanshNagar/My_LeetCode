class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int top = -1;
        int bottom = n;
        for (int i = 0; i < n - 1; i++) {
            if (top == -1 && nums[i] >= nums[i + 1]) top = i;
            if (bottom == n && nums[n - 1 - i] <= nums[n - 2 - i]) bottom = n - 1 - i;

            if (top > -1 && bottom < n) break;
        }
        if (top < 1 || bottom > n - 2) return false;
        for (int i = top; i < bottom; i++) {
            if (nums[i] <= nums[i + 1]) return false;
        }
        return true;
    }
}
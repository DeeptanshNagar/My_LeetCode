class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int j, k;
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == nums[i - 1]) continue;
            j = i - 1;
            k = i + 1;
            while (j >= 0 && nums[j] == nums[i]) j--;
            while (k < n && nums[k] == nums[i]) k++;
            if (j >= 0 && k < n) {
                if (nums[j] > nums[i] && nums[k] > nums[i]) count++;
                else if (nums[j] < nums[i] && nums[k] < nums[i]) count++;
            }
        }

        return count;
    }
}
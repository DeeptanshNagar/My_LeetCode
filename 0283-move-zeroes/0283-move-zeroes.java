class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // position for the next non-zero

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
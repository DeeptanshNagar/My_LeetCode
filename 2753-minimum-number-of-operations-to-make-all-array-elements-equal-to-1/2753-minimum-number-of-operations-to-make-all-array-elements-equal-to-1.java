class Solution {
    private int hcf(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int num1 = 0;
        int div = 0;
        for (int x : nums) {
            if (x == 1) num1++;
            div = hcf(div, x);
        }
        if (num1 > 0) return n - num1;
        if (div > 1) return -1;

        int min = n;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j < n; j++) {
                curr = hcf(curr, nums[j]);
                if (curr == 1) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min + n - 2;
    }
}
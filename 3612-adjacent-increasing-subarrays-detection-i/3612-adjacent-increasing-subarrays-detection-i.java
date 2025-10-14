class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (n < 2 * k) return false;
        int[] incLength = new int[n];
        incLength[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                incLength[i] = incLength[i - 1] + 1;
            } else {
                incLength[i] = 1;
            }
        }
        for (int i = k - 1; i < n - k; i++) {
            if (incLength[i] >= k && incLength[i + k] >= k) {
                return true;
            }
        }
        
        return false;
    }
}
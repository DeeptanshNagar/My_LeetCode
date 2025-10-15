class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] len = new int[n];
        
        len[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                len[i] = len[i + 1] + 1;
            } else {
                len[i] = 1;
            }
        }
        
        int maxK = 0;
        
        for (int i = 0; i < n; i++) {
            int currLen = len[i];
            maxK = Math.max(maxK, currLen / 2);
            
            int nextStart = i + currLen;
            if (nextStart < n) {
                int k = Math.min(currLen, len[nextStart]);
                maxK = Math.max(maxK, k);
            }
        }
        
        return maxK;
    }
}
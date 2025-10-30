class Solution {
        public int minNumberOperations(int[] target) {
        int ans = 0;
        int prev = 0;
        for (int num : target) {
            if(num > prev) {
                ans = ans + num - prev;
            }
            prev = num;
        }
        return ans;
    }
}
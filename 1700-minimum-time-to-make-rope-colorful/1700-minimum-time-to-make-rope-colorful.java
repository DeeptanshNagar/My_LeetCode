class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int ans = 0;
        int keep = neededTime[0];

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                ans += Math.min(keep, neededTime[i]);
                keep = Math.max(keep, neededTime[i]);
            } 
            else keep = neededTime[i];
        }
        return ans;
    }
}

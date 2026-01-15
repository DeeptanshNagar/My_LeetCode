class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxH = 1, maxV = 1;
        int curr = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] - hBars[i - 1] == 1) curr++;
            else curr = 1;
            maxH = Math.max(maxH, curr);
        }
        curr = 1;
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] - vBars[i - 1] == 1) curr++;
            else curr = 1;
            maxV = Math.max(maxV, curr);
        }
        int ans = Math.min(maxH, maxV) + 1;
        return ans * ans;
    }
}
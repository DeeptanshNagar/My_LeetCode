class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0, mx = 0;
        for (int x : gain)
            mx = Math.max(mx, sum += x);
        return mx;
    }
}
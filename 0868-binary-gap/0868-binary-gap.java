class Solution {
    public int binaryGap(int n) {
        int last = -1, ans = 0, i = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (last != -1) ans = Math.max(ans, i - last);
                last = i;
            }
            n >>= 1;
            i++;
        }
        return ans;
    }
}
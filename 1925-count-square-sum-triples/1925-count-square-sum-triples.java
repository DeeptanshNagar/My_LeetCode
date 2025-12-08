class Solution {
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public int countTriples(int n) {
        //int a = m^2 + n^2;
        //int b = m^2 - n^2;
        //int c = 2mn;
        int ans = 0;
        for (int i = 2; i * i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (((i - j) & 1) == 0 || gcd(i, j) != 1) continue;
                int temp = i * i + j * j;
                if (temp > n) continue;
                for (int k = 1; k * temp <= n; k++) ans += 2;
            }
        }
        return ans;
    }
}
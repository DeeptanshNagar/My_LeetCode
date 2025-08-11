class Solution {
        private long modPow(long base, long exp, int mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    public int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
        int powers[] = new int[31];
        int idx = 0;

        for (int i = 0; i < 31; i++) {
            if (((n >> i) & 1) == 1) {
                powers[idx++] = 1 << i;
            }
        }

        long prefix[] = new long[idx];
        prefix[0] = powers[0];
        for (int i = 1; i < idx; i++) {
            prefix[i] = (prefix[i - 1] * powers[i]) % mod;
        }

        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            if (l == 0) ans[i] = (int) prefix[r];
            else ans[i] = (int) ((prefix[r] * modPow(prefix[l - 1], mod - 2, mod)) % mod);
        }
        return ans;
    }
}

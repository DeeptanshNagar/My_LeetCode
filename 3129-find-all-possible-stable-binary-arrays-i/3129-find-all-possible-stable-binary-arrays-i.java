class Solution {
    static final int MOD = 1000000007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][] dp0 = new int[zero + 1][one + 1];
        int[][] dp1 = new int[zero + 1][one + 1];

        // only 0s
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp0[i][0] = 1;
        }

        // only 1s
        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp1[0][j] = 1;
        }

        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                if (i == 0 && j == 0) continue;

                if (i > 0 && j > 0) {
                    long ways0 = 0;
                    for (int k = 1; k <= limit && i - k >= 0; k++) {
                        ways0 = (ways0 + dp1[i - k][j]) % MOD;
                    }
                    dp0[i][j] = (int) ways0;

                    long ways1 = 0;
                    for (int k = 1; k <= limit && j - k >= 0; k++) {
                        ways1 = (ways1 + dp0[i][j - k]) % MOD;
                    }
                    dp1[i][j] = (int) ways1;
                }
            }
        }

        return (dp0[zero][one] + dp1[zero][one]) % MOD;
    }
}
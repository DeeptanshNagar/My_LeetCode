class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxPos = fruits[n - 1][0];

        int fruitAt[] = new int[maxPos + 2];
        for (int[] f : fruits) fruitAt[f[0]] = f[1];

        int prefix[] = new int[maxPos + 2];
        for (int i = 1; i < prefix.length; i++)
            prefix[i] = prefix[i - 1] + fruitAt[i - 1];

        int res = 0;

        for (int x = 0; x <= k; x++) {
            int left = Math.max(0, startPos - (k - 2 * x));
            int right = Math.min(maxPos, startPos + x);
            if (left > right) continue;
            res = Math.max(res, prefix[right + 1] - prefix[left]);
        }

        for (int x = 0; x <= k; x++) {
            int left = Math.max(0, startPos - x);
            int right = Math.min(maxPos, startPos + (k - 2 * x));
            if (left > right) continue;
            res = Math.max(res, prefix[right + 1] - prefix[left]);
        }
        return res;
    }
}

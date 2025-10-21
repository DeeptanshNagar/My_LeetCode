class Solution {
    class BIT {
        int n;
        int bit[];

        BIT(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        void update(int x, long v) {
            x++;
            while (x <= n) {
                bit[x] += v;
                x += x & (-x);
            }
        }

        long query(int x) {
            x++;
            long sum = 0;
            while (x > 0) {
                sum += bit[x];
                x -= x & (-x);
            }
            return sum;
        }
    }


    public int maxFrequency(int[] nums, int k, int numOperations) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) max = Math.max(max, num);

        BIT b = new BIT(max + 1);

        for (int num : nums) b.update(num, 1);

        for (int i = 0; i <= max; i++) {
            int left = Math.max(0, i - k);
            int right = Math.min(max, i + k);

            long leftSum = b.query(i) - b.query(left - 1);
            long rightSum = b.query(right) - b.query(i);
            long freq = b.query(i) - b.query(i - 1);

            ans = Math.max(ans, (int)Math.min(leftSum + rightSum, numOperations + freq));
        }

        return ans;
    }
}
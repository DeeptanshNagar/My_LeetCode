class Solution {
    class Fenwick {
        int n;
        int arr[];

        Fenwick(int n) {
            this.n = n + 1;
            arr = new int[n + 1];
        }

        void update(int i, int val) {
            i++;
            while (i < n) {
                arr[i] += val;
                i += (i & -i);
            }
        }

        int sum(int i) {
            i++;
            int ans = 0;
            while (i > 0) {
                ans += arr[i];
                i -= (i & -i);
            }
            return ans;
        }

        int sum(int i, int j) {
            if (j < i) return 0;
            return sum(j) - sum(i - 1);
        }
    }
    public int reversePairs(int[] nums) {
        int n = nums.length;
        Fenwick bit = new Fenwick(n);
        List<int[]> index = new ArrayList<>();
        for (int i = 0; i < n; i++) index.add(new int[]{nums[i], i});

        Collections.sort(index, (a, b) -> {
            int ra = Integer.compare(a[0], b[0]);
            return ra != 0 ? ra : Integer.compare(b[1], a[1]);
        });

        int i = 0, j = 0;
        int sum = 0;
        while (i < n) {
            int arr[] = index.get(i);
            while (j < n && 2 * (long)index.get(j)[0] < index.get(i)[0]) {
                bit.update(index.get(j)[1], 1);
                j++;
            }
            sum += bit.sum(arr[1] + 1, n - 1);
            i++;
        }
        return sum;
    }
}
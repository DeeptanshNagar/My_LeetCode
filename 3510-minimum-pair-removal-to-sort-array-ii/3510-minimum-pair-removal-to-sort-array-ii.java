class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        long num[] = new long[n];
        for (int i = 0; i < n; i++) num[i] = nums[i];
        int left[] = new int[n + 1];
        int right[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            left[i] = i - 1;
            right[i] = i + 1;
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        boolean remove[] = new boolean[n];
        int bad = 0;

        for (int i = 0; i < n - 1; i++) {
            pq.offer(new long[]{num[i]+num[i + 1], i});
            if (num[i] > num[i + 1]) bad++;
        }

        if (bad == 0) return 0;

        int ans = 0;
        while(bad > 0) {
            long b[] = pq.poll();

            long sum = b[0];
            int i = (int)b[1];
            int j = right[i];

            if (remove[i] || j == n) continue;
            if (sum != num[i] + num[j]) continue;

            if (left[i] != -1 && num[left[i]] > num[i]) bad--;
            if (num[i] > num[j]) bad--;
            if (right[j] != n && num[j] > num[right[j]]) bad--;

            remove[j] = true;
            
            if (right[j] != n && left[right[j]] != -1) left[right[j]] = i; 
            right[i] = right[j];
            
            num[i] = sum;

            if (left[i] != -1 && num[left[i]] > num[i]) bad++;
            if (right[j] != n && num[i] > num[right[j]]) bad++;

            if (left[i] != -1) pq.offer(new long[]{num[left[i]] + num[i], left[i]});
            if (right[i] != n) pq.offer(new long[]{num[i] + num[right[i]], i});
            ans++;
        }
        return ans;
    }
}
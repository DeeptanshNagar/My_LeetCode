class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int suffix[] = new int[n];
        suffix[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; i--) suffix[i] = Math.max(suffix[i + 1], events[i][2]);

        int max = 0;
        for (int i = 0; i < n; i++) {
            int curr = events[i][2];
            int j = binarySearch(events, events[i][1] + 1);
            if (j != -1) curr += suffix[j];
            max = Math.max(max, curr);
        }
        return max;
    }

    private int binarySearch(int events[][], int target) {
        int left = 0, right = events.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] >= target) right = mid - 1;
            else left = mid + 1;
        }
        return (left < events.length) ? left : -1;
    }

}
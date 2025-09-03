class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int high = points[i][1];
            int low = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int curr = points[j][1];
                if (curr <= high && curr > low) {
                    ans++;
                    low = curr;
                    if (curr == high) break;
                }
            }
        }
        return ans;
    }
}
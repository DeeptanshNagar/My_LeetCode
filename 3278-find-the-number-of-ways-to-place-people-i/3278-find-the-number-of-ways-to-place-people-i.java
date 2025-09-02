class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int maxY = Integer.MIN_VALUE; 
            for (int j = i + 1; j < n; j++) {
                if (points[i][1] >= points[j][1] && points[j][1] > maxY) {
                    ans++;
                    maxY = points[j][1];
                }
            }
        }

        return ans;
    }

    // Example run
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(sol.numberOfPairs(points));
    }
}
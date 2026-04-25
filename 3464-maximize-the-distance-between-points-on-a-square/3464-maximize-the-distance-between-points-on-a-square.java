class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        int[][] flattened = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int flatPos = 0;
            if (y == 0) {
                flatPos = x;
            } else if (x == side) {
                flatPos = side + y;
            } else if (y == side) {
                flatPos = 2 * side + (side - x);
            } else {
                flatPos = 3 * side + (side - y);
            }
            flattened[i][0] = flatPos;
            flattened[i][1] = x;
            flattened[i][2] = y;
        }
        
        Arrays.sort(flattened, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[][] sortedPts = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            sortedPts[i][0] = flattened[i][1];
            sortedPts[i][1] = flattened[i][2];
            sortedPts[i + n][0] = flattened[i][1];
            sortedPts[i + n][1] = flattened[i][2];
        }
        
        int left = 1;
        int right = 2 * side;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isSatisfyManhattan(mid, sortedPts, n, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
    
    private boolean isSatisfyManhattan(int threshold, int[][] sortedPts, int n, int k) {
        int[] nextPt = new int[2 * n];
        int j = 1;
        for (int i = 0; i < 2 * n; i++) {
            if (j <= i) {
                j = i + 1;
            }
            while (j < 2 * n) {
                int dist = Math.abs(sortedPts[i][0] - sortedPts[j][0]) + Math.abs(sortedPts[i][1] - sortedPts[j][1]);
                if (dist >= threshold) {
                    break;
                }
                j++;
            }
            nextPt[i] = j;
        }
        
        int minDiff = 2 * n + 1;
        int iMin = -1;
        for (int i = 0; i < n; i++) {
            if (nextPt[i] - i < minDiff) {
                minDiff = nextPt[i] - i;
                iMin = i;
            }
        }
        
        if (minDiff > n / k) {
            return false;
        }
        
        for (int startIdx = iMin; startIdx <= nextPt[iMin]; startIdx++) {
            int start = startIdx % n;
            int curr = start;
            boolean valid = true;
            for (int step = 0; step < k; step++) {
                curr = nextPt[curr];
                if (curr >= 2 * n) {
                    valid = false;
                    break;
                }
            }
            if (valid && curr <= start + n) {
                return true;
            }
        } 
        return false;
    }
}
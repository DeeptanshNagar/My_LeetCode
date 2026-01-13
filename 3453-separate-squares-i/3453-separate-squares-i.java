class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];
            totalArea += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double targetArea = totalArea / 2.0;

        for (int i = 0; i < 100; i++) {
            double mid = low + (high - low) / 2.0;
            double currentArea = 0;

            for (int[] s : squares) {
                double y = s[1];
                double l = s[2];
                
                double hBelow = Math.max(0, Math.min(l, mid - y));
                currentArea += hBelow * l;
            }

            if (currentArea < targetArea) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
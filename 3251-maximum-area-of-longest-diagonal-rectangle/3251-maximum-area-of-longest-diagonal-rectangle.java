class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = -1;
        int maxArea = -1;

        for (int[] d : dimensions) {
            int l = d[0], w = d[1];
            int diagonal = l * l + w * w;
            int area = l * w;

            if (diagonal > maxDiagonal || (diagonal == maxDiagonal && area > maxArea)) {
                maxDiagonal = diagonal;
                maxArea = area;
            }
        }
        return maxArea;
    }
}

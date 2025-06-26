class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
    
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // {{1, 3}, {2, 6}, {8, 10}, {15, 18}}

        int[][] temp = new int[n][2]; 
        // [ [0, 0], [0, 0], [0, 0], [0, 0] ]

        int index = -1; 
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0]; 
            int end = intervals[i][1]; 
            if (index == -1 || start > temp[index][1]) {  
                index++;
                temp[index][0] = start; 
                temp[index][1] = end;   
            } else {
                temp[index][1] = Math.max(temp[index][1], end);
            }
        }
        int[][] result = new int[index + 1][2];
        for (int i = 0; i <= index; i++) {
            result[i][0] = temp[i][0];
            result[i][1] = temp[i][1];
        }
        return result;
    }
}
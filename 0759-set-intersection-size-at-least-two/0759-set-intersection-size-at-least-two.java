class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int answer = 0;
        int max = -1;
        int secondMax = -1;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            }
        });
        for(int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(secondMax >= start) {
                continue;
            }
            if(max >= start) {
                secondMax = max;
                max = end;
                answer = answer + 1;
            } else {
                max = end;
                secondMax = end - 1;
                answer = answer + 2;
            }
        }
        return answer;
    }
}
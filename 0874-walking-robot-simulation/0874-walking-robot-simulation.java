class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int obstacle[] : obstacles) set.add(Arrays.toString(obstacle));
        int ans = 0;
        int x = 0, y = 0;
        int dir = 0;
        for (int command : commands) {
            if (command == -2) dir = ((dir - 1) % 4 + 4) % 4;
            else if (command == -1) dir = ((dir + 1) % 4 + 4) % 4;
            else {
                int nx = x, ny = y;
                for (int i = 1; i <= command; i++) {
                    if (dir == 0) ny++;
                    else if (dir == 1) nx++;
                    else if (dir == 2) ny--;
                    else nx--;

                    if (set.contains(Arrays.toString(new int[]{nx, ny}))) break;
                    else {
                        x = nx;
                        y = ny;
                        int curr = (x * x) + (y * y);
                        if (curr > ans) ans = curr;
                    } 
                }
            }
        }
        return ans;
    }
}
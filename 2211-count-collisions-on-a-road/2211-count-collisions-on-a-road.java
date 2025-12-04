class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0, right = n - 1;
        int ans = 0;
        while (left < n && directions.charAt(left) == 'L') left++;
        while (right >= 0 && directions.charAt(right) == 'R') right--;

        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') ans++;
        }   
        return ans;
    }
}
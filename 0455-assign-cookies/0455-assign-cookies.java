class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int gLen = g.length;
        int sLen = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        while( i < gLen && j < sLen) {
            if(g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        
        return i;
    }
}
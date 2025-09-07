class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int i = 0;

        if ((n & 1) == 1){
            ans[i++] = 0;
        }

        int k = 1;

        while (i < n) {
            ans[i] = -k;
            i++;
            ans[i] = k;
            i++;
            k++;
        } 

        return ans;
    }
}
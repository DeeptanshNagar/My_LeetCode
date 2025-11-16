class Solution {
    public int numSub(String s) {
        int mod = 1000000007;
        long ans = 0, curr = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                curr++;
                ans += curr;
            } 
            else curr = 0;
        }
        return (int)(ans % mod);
    }
}
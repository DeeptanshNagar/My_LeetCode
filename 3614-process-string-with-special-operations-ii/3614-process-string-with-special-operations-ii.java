class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n];
        long cur = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                cur++;
            } 
            else if (ch == '*') {
                if (cur > 0) cur--;
            } 
            else if (ch == '#') {
                cur = Math.min(cur * 2, (long)1e15);
            }

            len[i] = cur;
        }

        if (k >= cur) return '.';

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (len[i] - 1 == k) return ch;
            } 
            else if (ch == '#') {
                long prev = len[i] / 2;
                if (k >= prev) k -= prev;
            } 
            else if (ch == '%') {
                k = len[i] - 1 - k;
            }
        }
        return '.';
    }
}
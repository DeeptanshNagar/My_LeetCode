class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int len = n + m - 1;

        char ans[] = new char[len];
        boolean fixed[] = new boolean[len];

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int p = i + j;
                    char c = str2.charAt(j);
                    if (ans[p] != '\0' && ans[p] != c) return "";
                    ans[p] = c;
                    fixed[p] = true;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (ans[i] == '\0') ans[i] = 'a';
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F' && matches(ans, i, str2)) {
                boolean changed = false;
                for (int j = m - 1; j >= 0; j--) {
                    int p = i + j;
                    if (!fixed[p]) {
                        ans[p] = ans[p] == 'a' ? 'b' : 'a';
                        changed = true;
                        break;
                    }
                }
                if (!changed) return "";
            }
        }

        for (int i = 0; i < n; i++) {
            boolean eq = matches(ans, i, str2);
            if (str1.charAt(i) == 'T' && !eq) return "";
            if (str1.charAt(i) == 'F' && eq) return "";
        }

        return new String(ans);
    }

    private boolean matches(char[] ans, int start, String str2) {
        for (int j = 0; j < str2.length(); j++) {
            if (ans[start + j] != str2.charAt(j)) return false;
        }
        return true;
    }
}
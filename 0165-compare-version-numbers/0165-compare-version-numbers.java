class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int n = Math.max(a.length, b.length);
        for (int i = 0; i < n; i++) {
            String s1 = i < a.length ? stripLeadingZeros(a[i]) : "0";
            String s2 = i < b.length ? stripLeadingZeros(b[i]) : "0";
            if (s1.length() != s2.length()) return s1.length() > s2.length() ? 1 : -1;
            int cmp = s1.compareTo(s2);
            if (cmp != 0) return cmp > 0 ? 1 : -1;
        }
        return 0;
    }
    String stripLeadingZeros(String s){
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0'){
            i++;
        }
        return i == s.length() ? "0" : s.substring(i);
    }
}

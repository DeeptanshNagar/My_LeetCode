class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = s.charAt(i) - '0';
        for (int len = n; len > 1; len--) {
            for (int j = 0; j < len - 1; j++) {
                arr[j] = (arr[j] + arr[j + 1]) % 10;
            }
            if (len - 1 == 2) return arr[0] == arr[1];
        }
        return false;
    }
}